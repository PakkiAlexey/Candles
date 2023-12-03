package com.candles.demo.service;

import com.candles.demo.model.Candle;
import com.candles.demo.repository.CandleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandleService {
    private final CandleRepository candleRepository;

    public List<Candle> getSimilarCandles(String id) {
        Optional<Candle> candle = candleRepository.findById(id);
        if (candle.isPresent()) {
            List<Candle> similarByAroma = candleRepository.findAllByAroma(candle.get().getAroma());
            List<Candle> similarByVolume = candleRepository.findAllByVolume(candle.get().getVolume());
            List<Candle> similarBySlug = candleRepository.findAllBySlug(candle.get().getSlug());
            return List.of(similarByAroma, similarByVolume, similarBySlug).stream().flatMap(List::stream)
                    .distinct()
                    .limit(4)
                    .toList();
        }
        return candleRepository.findAll().stream().limit(4).toList();
    }
}
