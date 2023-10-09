package com.candles.demo.services;

import com.candles.demo.dto.CandleDto;
import com.candles.demo.model.Candle;
import com.candles.demo.persistence.CandleRepository;
import com.candles.demo.utils.CandleDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CandleService {
    private final CandleRepository candleRepository;

    @Autowired
    public CandleService(CandleRepository candleRepository) {
        this.candleRepository = candleRepository;
    }

    public CandleDto findCandleById(String id) {
        return candleRepository.findById(id)
                .map(CandleDtoConverter::toDto)
                .orElseThrow();
    }

    public CandleDto createCandle(CandleDto candleDto) {
        return CandleDtoConverter.toDto(candleRepository.save(CandleDtoConverter.toModel(candleDto)));
    }

    public CandleDto updateCandle(String id, CandleDto candleDto) {
        Candle candle = candleRepository.findById(id).orElseThrow();

        candle.setTitle(candleDto.getTitle());
        candle.setName(candleDto.getName());
        candle.setWax(candleDto.getWax());
        candle.setContainer(candleDto.getContainer());
        candle.setVolume(candleDto.getVolume());
        candle.setPrice(candleDto.getPrice());
        candle.setDescription(candleDto.getDescription());
        candle.setContainerColor(candleDto.getContainerColor());
        candle.setWarColor(candleDto.getWarColor());

        return CandleDtoConverter.toDto(candleRepository.save(candle));
    }

    public void deleteCandleById(String id) {
        candleRepository.deleteById(id);
    }

    public Page<Candle> findCandleByWax(String wax, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return candleRepository.findCandleByWax(wax, pageable);
    }
}
