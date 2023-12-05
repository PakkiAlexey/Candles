package com.candles.demo.dto;

import com.candles.demo.model.Kit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxDto extends RepresentationModel<BoxDto> {
    private String id;
    private String title;
    private String name;
    private String volume;
    private BigDecimal price;
    private String description;
    private Kit kit;
    private String image;
}
