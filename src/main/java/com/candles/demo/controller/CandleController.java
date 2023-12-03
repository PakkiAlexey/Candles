package com.candles.demo.controller;

import com.candles.demo.model.Candle;
import com.candles.demo.repository.CandleRepository;
import com.candles.demo.service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/candles")
@RequiredArgsConstructor
public class CandleController {

    private final CandleRepository candleRepository;
    private final FileService fileService;

    @PostMapping("/create")
    public void createCandle(HttpServletResponse response,
                             @RequestParam("model") String model,
                             @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Candle candle = objectMapper.readValue(model, Candle.class);

        if (!file.isEmpty()) {
            try {
                String filePath = fileService.write(file);
                candle.setImage(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Candle savesCandle = candleRepository.save(candle);
        response.sendRedirect("/candles/" + savesCandle.getId());
    }
}
