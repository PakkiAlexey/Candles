package com.candles.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchResultEntity {
    private String id;
    private String title;
    private String name;
}
