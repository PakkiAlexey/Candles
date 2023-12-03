package com.candles.demo.controller;

import com.candles.demo.model.SearchResultEntity;
import com.candles.demo.repository.BoxRepository;
import com.candles.demo.repository.CandleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final BoxRepository boxRepository;
    private final CandleRepository candleRepository;

    @GetMapping
    public List<SearchResultEntity> search(@RequestParam String pattern) {
        Stream<SearchResultEntity> candles = candleRepository.searchByPattern(pattern).stream()
                .map(candle ->{
                    SearchResultEntity searchResultEntity = new SearchResultEntity(candle.getId(), candle.getTitle(), candle.getName());
                    return searchResultEntity;
                });

        Stream<SearchResultEntity> boxes = boxRepository.searchByPattern(pattern).stream()
                .map(box ->{
                    SearchResultEntity searchResultEntity = new SearchResultEntity(box.getId(), box.getTitle(), box.getName());
                    return searchResultEntity;
                });
        return Stream.concat(boxes, candles).collect(Collectors.toList());
    }
}
