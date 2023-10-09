package com.candles.demo.dto;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Field;

import java.awt.*;
import java.math.BigDecimal;

@Builder
@Value
public final class CandleDto {
    private String title;
    private String name;
    private String wax;
    private String container;
    private String volume;
    private BigDecimal price;
    private String description;
    private String containerColor;
    private String warColor;
}
