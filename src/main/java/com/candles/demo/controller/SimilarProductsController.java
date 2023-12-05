package com.candles.demo.controller;

import com.candles.demo.dto.BoxDto;
import com.candles.demo.dto.CandleDto;
import com.candles.demo.mapper.BoxMapper;
import com.candles.demo.mapper.CandleMapper;
import com.candles.demo.model.Box;
import com.candles.demo.model.Candle;
import com.candles.demo.service.BoxServices;
import com.candles.demo.service.CandleService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/similar-products")
public class SimilarProductsController {
    private final CandleService candleService;
    private final BoxServices boxServices;
    private final EntityLinks entityLinks;
    private final BoxMapper boxMapper;
    private final CandleMapper candleMapper;

    @GetMapping("/candles")
    public ResponseEntity<CollectionModel<CandleDto>> getCandles(@RequestParam String id) {
        List<CandleDto> candleDtos = candleService.getSimilarCandles(id).stream()
                .map(candleMapper::toDto)
                .peek(candle -> candle.add(entityLinks.linkToItemResource(Candle.class, candle.getId())))
                .toList();
        return ResponseEntity.ok(CollectionModel.of(candleDtos));
    }

    @GetMapping("/boxes")
    public ResponseEntity<CollectionModel<BoxDto>> getBoxes(@RequestParam String id) {
        List<BoxDto> boxDtos = boxServices.getSimilarBoxes(id).stream()
                .map(boxMapper::toDto)
                .peek(box -> box.add(entityLinks.linkToItemResource(Box.class, box.getId())))
                .toList();
        return ResponseEntity.ok(CollectionModel.of(boxDtos));
    }
}
