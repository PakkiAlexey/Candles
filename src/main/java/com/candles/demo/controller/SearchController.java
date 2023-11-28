package com.candles.demo.controller;

import com.candles.demo.model.Box;
import com.candles.demo.model.Candle;
import com.candles.demo.model.SearchResponse;
import com.candles.demo.repository.BoxRepository;
import com.candles.demo.repository.CandleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final BoxRepository boxRepository;
    private final CandleRepository candleRepository;
    private final RepositoryEntityLinks entityLinks;

    @GetMapping
    public SearchResponse search(@RequestParam String pattern) {
        List<Candle> candles = candleRepository.searchByPattern(pattern).stream()
                .peek(candle -> {
                    Link link = entityLinks.linkToItemResource(candle, Candle::getId);
                    candle.setLink(link);
                })
                .collect(Collectors.toList());
        List<Box> boxes = boxRepository.searchByPattern(pattern).stream()
                .peek(box -> {
                    Link link = entityLinks.linkToItemResource(box, Box::getId);
                    box.setLink(link);
                })
                .collect(Collectors.toList());
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setCandles(candles);
        searchResponse.setBoxes(boxes);
        return ResponseEntity.ok(searchResponse).getBody();
    }
}
