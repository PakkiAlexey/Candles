package com.candles.demo.controllers;

import com.candles.demo.dto.Responsable;
import com.candles.demo.dto.SearchDTO;
import com.candles.demo.services.BoxService;
import com.candles.demo.services.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController()
@RequestMapping("/search")
public class SearchController {
    @Autowired
    CandleService candleService;
    @Autowired
    BoxService boxService;
    @GetMapping("")
    public SearchDTO search(@RequestParam String pattern) {
        List<Responsable> candles = candleService.searchByPattern(pattern);
        List<Responsable> boxes = boxService.searchByPattern(pattern);

        List<Responsable> responsableList = Stream.concat(candles.stream(), boxes.stream())
                .collect(Collectors.toList());

        return SearchDTO.builder()
                .boxesAndCandles(responsableList)
                .build();
    }
}
