package com.example.ProductServiceProxy.inhertanceExamples.singleTableForAllClasses;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "singleTable_Instructor")
@DiscriminatorValue(value = "3")
@Getter @Setter
public class Instructor extends User {
    private String company;
}
