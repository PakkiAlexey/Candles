package com.candles.demo.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/images")
public class ImageController {
    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[]  showImage(@RequestParam("image") String image) throws IOException {
        String imagePath = "src" +  File.separator + "images";
        String filePath = imagePath + File.separator + image;
        FileInputStream input = new FileInputStream(filePath);
        return IOUtils.toByteArray(input);
    }
}
