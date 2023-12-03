package com.candles.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Candle {
    @Id
    private String id;
    private String title;
    private String name;
    private String wax;
    private String slug;
    private Aroma aroma;
    private String wick;
    private Integer wicks;
    private String container;
    private String volume;
    private BigDecimal price;
    private String description;
    private String containerColor;
    private String waxColor;
    private String image;
}

