package com.candles.demo.controller;

import com.candles.demo.model.Box;
import com.candles.demo.repository.BoxRepository;
import com.candles.demo.service.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/boxes")
@RequiredArgsConstructor
public class BoxController {
    private final BoxRepository boxRepository;
    private final FileService fileService;
    @PostMapping("/create")
    public void createCandle(HttpServletResponse response,
                             @RequestParam("model") String model,
                             @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Box box = objectMapper.readValue(model, Box.class);

        if (!file.isEmpty()) {
            try {
                String filePath = fileService.write(file);
                box.setImage(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Box savedBox = boxRepository.save(box);
        response.sendRedirect("/boxes/" + savedBox.getId());
    }
}
