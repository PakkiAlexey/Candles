package com.candles.demo.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class FileService {
    public FileService() {
    }

    public String write(MultipartFile file) throws IOException {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
        String fileName = date + file.getOriginalFilename();
        String imagePath = "src" + File.separator + "images";
        String filePath = imagePath + File.separator + fileName;

        // Copies Spring's multipartfile inputStream to /src/images (absolute path)
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }
}
