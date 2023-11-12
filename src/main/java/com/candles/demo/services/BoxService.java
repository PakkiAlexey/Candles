package com.candles.demo.services;

import com.candles.demo.dto.BoxDto;
import com.candles.demo.model.Box;
import com.candles.demo.persistence.BoxRepository;
import com.candles.demo.utils.BoxDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoxService {
    private final BoxRepository boxRepository;

    @Autowired
    public BoxService(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    public BoxDto getBoxById(String id) {
        return boxRepository.findById(id)
                .map(BoxDtoConverter::toDto)
                .orElseThrow();
    }

    public List<BoxDto> findAll() {
        return boxRepository.findAll().stream()
                .map(BoxDtoConverter::toDto)
                .collect(Collectors.toList());
    }

    public BoxDto createBox(BoxDto boxDto) {
        return BoxDtoConverter.toDto(boxRepository.save(BoxDtoConverter.toBox(boxDto)));
    }

    public BoxDto updateBox(String id, BoxDto boxDto) {
        Box box = boxRepository.findById(id).orElseThrow();
        box.setName(boxDto.getName());
        box.setTitle(box.getTitle());
        box.setVolume(boxDto.getVolume());
        box.setDescription(boxDto.getDescription());
        box.setPrice(boxDto.getPrice());
        box.setWick(boxDto.getWick());

        return BoxDtoConverter.toDto(boxRepository.save(box));
    }

    public void deleteBoxById(String id) {
        boxRepository.deleteById(id);
    }

    public List<BoxDto> searchByPattern(String pattern) {
        return boxRepository.findBoxByPattern(pattern).stream()
                .map(BoxDtoConverter::toDto)
                .collect(Collectors.toList());
    }
}
