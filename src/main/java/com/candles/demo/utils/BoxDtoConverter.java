package com.candles.demo.utils;

import com.candles.demo.dto.BoxDto;
import com.candles.demo.model.Box;

public class BoxDtoConverter {
    public static BoxDto toDto(Box box) {
        return BoxDto.builder()
                .id(box.getId())
                .title(box.getTitle())
                .name(box.getName())
                .wick(box.getWick())
                .volume(box.getVolume())
                .price(box.getPrice())
                .description(box.getDescription())
                .slug("/boxes")
                .build();
    }

    public static Box toBox(BoxDto boxDto) {
        Box box = new Box();
        box.setTitle(boxDto.getTitle());
        box.setName(boxDto.getName());
        box.setWick(boxDto.getWick());
        box.setVolume(boxDto.getVolume());
        box.setPrice(boxDto.getPrice());
        box.setDescription(boxDto.getDescription());
        return box;
    }
}
