package com.candles.demo.mapper;

import com.candles.demo.dto.BoxDto;
import com.candles.demo.model.Box;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BoxMapper {
    Box toEntity(BoxDto boxDto);

    BoxDto toDto(Box box);

    List<BoxDto> toDtoList(List<Box> boxes);
}
