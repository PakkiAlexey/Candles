package com.candles.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchDTO {
    private List<Responsable> boxesAndCandles;
}
