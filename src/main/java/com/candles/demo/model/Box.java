package com.candles.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Box {
    @Id
    private String id;
    private String title;
    private String name;
    private String volume;
    private BigDecimal price;
    private String description;
    private Kit kit;
    private String image;
}
