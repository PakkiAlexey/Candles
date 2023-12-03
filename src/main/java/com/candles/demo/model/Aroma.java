package com.candles.demo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonSerialize
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aroma {
    private String name;
    private List<String> topNotes;
    private List<String> baseNotes;
}
