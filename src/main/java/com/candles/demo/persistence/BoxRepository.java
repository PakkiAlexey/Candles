package com.candles.demo.persistence;

import com.candles.demo.model.Box;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoxRepository extends MongoRepository<Box, String> {
    @Query("{ '$or': [ { 'name' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'title' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'volume' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'description' : { '$regex': ?0, '$options': 'i' } }, " +
            "{ 'wick' : { '$regex': ?0, '$options': 'i' } } ] }")
    List<Box> findBoxByPattern(String pattern);

}
