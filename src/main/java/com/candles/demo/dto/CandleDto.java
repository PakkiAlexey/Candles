package com.candles.demo.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class CandleDto {
    private String title;
    private String name;
    private String aroma;
    private String wax;
    private String wick;
    private String container;
    private String volume;
    private BigDecimal price;
    private String description;
    private String containerColor;
    private String warColor;
}
