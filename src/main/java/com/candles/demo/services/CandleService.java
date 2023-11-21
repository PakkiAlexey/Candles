package com.candles.demo.services;

import com.candles.demo.dto.CandleDto;
import com.candles.demo.dto.Responsable;
import com.candles.demo.model.Candle;
import com.candles.demo.persistence.CandleRepository;
import com.candles.demo.utils.CandleDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandleService {
    private final CandleRepository candleRepository;

    @Autowired
    public CandleService(CandleRepository candleRepository) {
        this.candleRepository = candleRepository;
    }

    public List<CandleDto> findAll() {
        return candleRepository.findAll().stream()
                .map(CandleDtoConverter::toDto)
                .collect(Collectors.toList());
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
        candle.setAroma(candleDto.getAroma());
        candle.setWax(candleDto.getWax());
        candle.setWick(candleDto.getWick());
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

    public List<Responsable> searchByPattern(String pattern) {
        return candleRepository.findCandleByPattern(pattern).stream()
                .map(CandleDtoConverter::toDto)
                .collect(Collectors.toList());
    }
}
