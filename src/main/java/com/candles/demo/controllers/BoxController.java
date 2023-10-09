package com.candles.demo.controllers;


import com.candles.demo.dto.BoxDto;
import com.candles.demo.services.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/boxes"))
public class BoxController {

    @Autowired
    private BoxService boxService;
    @GetMapping("")
    public List<BoxDto> findAll() {
        return boxService.findAll();
    }
    @GetMapping("{id}")
    public BoxDto getBoxById(@PathVariable String id) {
        return boxService.getBoxById(id);
    }

    @PostMapping("")
    public BoxDto createBox(@RequestBody BoxDto box) {
        return boxService.createBox(box);
    }

    @PutMapping("{id}")
    public BoxDto updateBox(@PathVariable String id, @RequestBody BoxDto box) {
        return boxService.updateBox(id, box);
    }

    @DeleteMapping("{id}")
    public void deleteBox(@PathVariable String id) {
        boxService.deleteBoxById(id);
    }
}
