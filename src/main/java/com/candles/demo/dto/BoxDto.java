package com.candles.demo.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Builder
@Value
public class BoxDto implements Responsable{
    private String id;
    private String title;
    private String name;
    private String wick;
    private String volume;
    private BigDecimal price;
    private String description;
    private String slug;
}


