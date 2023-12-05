package com.candles.demo.dto;

import com.candles.demo.model.Aroma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandleDto extends RepresentationModel<CandleDto> {
    private String id;
    private String title;
    private String name;
    private String wax;
    private String slug;
    private Aroma aroma;
    private String wick;
    private Integer wicks;
    private String container;
    private String volume;
    private BigDecimal price;
    private String description;
    private String containerColor;
    private String waxColor;
    private String image;
}
