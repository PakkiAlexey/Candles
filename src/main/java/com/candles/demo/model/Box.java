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
public class Box {
    @Id
    private String id;
    private String title;
    private String name;
    private String volume;
    private BigDecimal price;
    private String description;
    private Kit kit;
    private String image;
}
