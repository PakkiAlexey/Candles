package com.candles.demo.controller;

import com.candles.demo.model.Box;
import com.candles.demo.model.Candle;
import com.candles.demo.service.BoxServices;
import com.candles.demo.service.CandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/similar-products")
public class SimilarProductsController {
    private final CandleService candleService;
    private final BoxServices boxServices;

    @GetMapping("/candles")
    public List<Candle> getCandles(@PathVariable String id) {
        return candleService.getSimilarCandles(id);
    }

    @GetMapping("/boxes")
    public List<Box> getBoxes(@PathVariable String id) {
        return boxServices.getSimilarBoxes(id);
    }

}
