package com.candles.demo.utils;

import com.candles.demo.dto.CandleDto;
import com.candles.demo.model.Candle;

public class CandleDtoConverter {
    private CandleDtoConverter() {
    }

    public static CandleDto toDto(Candle candle) {
        return CandleDto.builder()
                .title(candle.getTitle())
                .name(candle.getName())
                .aroma(candle.getAroma())
                .wax(candle.getWax())
                .wick(candle.getWick())
                .container(candle.getContainer())
                .volume(candle.getVolume())
                .price(candle.getPrice())
                .description(candle.getDescription())
                .containerColor(candle.getContainerColor())
                .warColor(candle.getWarColor())
                .build();
    }

    public static Candle toModel(CandleDto candleDto) {
        Candle candle = new Candle();
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

        return candle;
    }
}
