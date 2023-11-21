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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        Collections.addAll(list);
        Collections.addAll(list1);
    }
}


