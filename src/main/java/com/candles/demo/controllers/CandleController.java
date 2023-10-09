package com.candles.demo.controllers;

import com.candles.demo.dto.CandleDto;
import com.candles.demo.model.Candle;
import com.candles.demo.services.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candles")
public class CandleController {

    @Autowired
    private CandleService candleService;
    @GetMapping("{id}")
    public CandleDto getCandleById(@PathVariable String id) {
        return candleService.findCandleById(id);
    }

    @PostMapping("")
    public CandleDto createCandle(@RequestBody CandleDto candle) {
        return candleService.createCandle(candle);
    }
    
    @PutMapping("{id}")
    public CandleDto updateCandle(@PathVariable String id, @RequestBody CandleDto candle) {
        return candleService.updateCandle(id, candle);
    }

    @DeleteMapping("{id}")
    public void deleteCandle(@PathVariable String id) {
        candleService.deleteCandleById(id);
    }


    @GetMapping("")
    public Page<Candle> getCandleByWax(@RequestParam String wax, @RequestParam int size) {
        return candleService.findCandleByWax(wax, 1,size);
    }
}
