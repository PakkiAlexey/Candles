package com.candles.demo.repository;

import com.candles.demo.model.Box;
import com.candles.demo.model.QBox;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "boxes", path = "boxes")
public interface BoxRepository extends MongoRepository<Box, String>, QuerydslPredicateExecutor<Box>,
        QuerydslBinderCustomizer<QBox> {
    @Query("{ '$or': [ { 'name' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'title' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'volume' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'description' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'wick' : { '$regex': ?0, '$options': 'i' } } ] }")
    List<Box> searchByPattern(String pattern);

    @Override
    default void customize(QuerydslBindings bindings, QBox root) {
        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
    }

}
