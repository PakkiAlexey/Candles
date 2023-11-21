package com.candles.demo.persistence;

import com.candles.demo.model.Candle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandleRepository extends MongoRepository<Candle, String> {
    Page<Candle> findCandleByWax(String wax, Pageable pageable);

    @Query("{ '$or': [ { 'name' : { '$regex': ?0, '$options': 'i' }}," +
            "{'title' : { '$regex': ?0, '$options': 'i' }}," +
            "{'aroma' : { '$regex': ?0, '$options': 'i' }}," +
            " {'volume' : { '$regex': ?0, '$options': 'i' }}," +
            " {'description' : { '$regex': ?0, '$options': 'i' }}," +
            " {'container' : { '$regex': ?0, '$options': 'i' }}," +
            " {'wax' : { '$regex': ?0, '$options': 'i' }}," +
            " {'wick' : { '$regex': ?0, '$options': 'i' }} ] }")
    List<Candle> findCandleByPattern(String pattern);

}
