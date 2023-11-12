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
//
//id: 1,
//        title: 'Соєва свічка Чорне море',
//        name:'Чорне море',
//        aroma: 'Чорне море',
//        wax: 'soy coconut palm',
//        wick: '',
//        wicks: 1,
//        container: 'glass',
//        volume: '280ml',
//        price: 450,
//        description: '',
//        containerColor: '',
//        waxColor: '',
//        images: [],
