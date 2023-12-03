package com.candles.demo.controller;

import com.candles.demo.model.Box;
import com.candles.demo.model.Candle;
import com.candles.demo.service.BoxServices;
import com.candles.demo.service.CandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/similar-products")
public class SimilarProductsController {
    private final CandleService candleService;
    private final BoxServices boxServices;

    @GetMapping("/candles")
    public List<Candle> getCandles(@RequestParam String id) {
        return candleService.getSimilarCandles(id);
    }

    @GetMapping("/boxes")
    public List<Box> getBoxes(@RequestParam String id) {
        return boxServices.getSimilarBoxes(id);
    }

}
