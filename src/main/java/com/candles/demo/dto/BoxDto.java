package com.candles.demo.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class BoxDto {
    private String title;
    private String name;

    private String wick;
    private String volume;
    private BigDecimal price;
    private String description;
}
