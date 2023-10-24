package com.example.ProductServiceProxy.inhertanceExamples.singleTableForAllClasses;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "SingleTable_TA") // this will privide the name of the table in the database
@DiscriminatorValue(value = "1")
public class TA extends User {
    private double rating;
}
