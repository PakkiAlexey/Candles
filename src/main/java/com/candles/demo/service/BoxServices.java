package com.candles.demo.service;

import com.candles.demo.model.Box;
import com.candles.demo.repository.BoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoxServices {
    private final BoxRepository boxRepository;
    public List<Box> getSimilarBoxes(String id) {
        Optional<Box> box = boxRepository.findById(id);
        if (box.isPresent()) {
            List<Box> similarByPrice = boxRepository.findAllByPrice(box.get().getPrice());
            List<Box> similarByVolume = boxRepository.findAllByVolume(box.get().getVolume());
            return List.of(similarByPrice, similarByVolume).stream().flatMap(List::stream)
                    .distinct()
                    .limit(4)
                    .toList();
        }
        return boxRepository.findAll().stream().limit(4).toList();
    }
}
