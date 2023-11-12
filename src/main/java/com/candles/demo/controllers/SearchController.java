package com.candles.demo.controllers;

import com.candles.demo.dto.SearchDTO;
import com.candles.demo.services.BoxService;
import com.candles.demo.services.CandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/search")
public class SearchController {
    @Autowired
    CandleService candleService;
    @Autowired
    BoxService boxService;
    @GetMapping("")
    public SearchDTO search(@RequestParam String pattern) {
        return SearchDTO.builder()
                .candleList(candleService.searchByPattern(pattern))
                .boxList(boxService.searchByPattern(pattern))
                .build();
    }
}
