package com.example.ProductServiceProxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class RatingDto {
    private double rate;
    private int count;
}
