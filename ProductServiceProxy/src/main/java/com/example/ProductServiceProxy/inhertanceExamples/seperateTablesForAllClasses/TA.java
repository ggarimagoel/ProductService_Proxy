package com.example.ProductServiceProxy.inhertanceExamples.seperateTablesForAllClasses;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "TablePerClass_TA") // this will privide the name of the table in the database
public class TA extends User{
    private double rating;
}
