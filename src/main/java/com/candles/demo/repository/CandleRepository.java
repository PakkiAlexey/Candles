package com.candles.demo.repository;

import com.candles.demo.model.Aroma;
import com.candles.demo.model.Candle;
import com.candles.demo.model.QCandle;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "candles", path = "candles")
public interface CandleRepository extends MongoRepository<Candle, String>, QuerydslPredicateExecutor<Candle>,
        QuerydslBinderCustomizer<QCandle> {
    @Query("{ '$or': [ { 'name' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'title' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'volume' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'description' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'wick' : { '$regex': ?0, '$options': 'i' } } ] }")
    List<Candle> searchByPattern(String pattern);

    @Override
    default void customize(QuerydslBindings bindings, QCandle root) {
        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
    }

    @RestResource(exported = false)
    List<Candle> findAllByAroma(Aroma aroma);
    @RestResource(exported = false)
    List<Candle> findAllByVolume(String volume);
    @RestResource(exported = false)
    List<Candle> findAllBySlug(String slug);
}
