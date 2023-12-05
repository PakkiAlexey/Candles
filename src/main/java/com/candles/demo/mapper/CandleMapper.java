package com.candles.demo.mapper;

import com.candles.demo.dto.CandleDto;
import com.candles.demo.model.Candle;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CandleMapper {

    Candle toEntity(CandleDto candleDto);

    CandleDto toDto(Candle candle);

    List<CandleDto> toDtoList(List<Candle> boxes);
}
