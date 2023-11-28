package com.candles.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private List<Candle> candles;
    private List<Box> boxes;
}
