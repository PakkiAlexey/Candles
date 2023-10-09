package com.candles.demo.persistence;

import com.candles.demo.model.Candle;
import com.candles.demo.services.CandleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandleRepository extends MongoRepository<Candle, String> {
    Page<Candle> findCandleByWax(String wax, Pageable pageable);
}
