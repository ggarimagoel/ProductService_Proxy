package com.example.ProductServiceProxy.inhertanceExamples.seperateTablesForAllClasses;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TablePerClass_Instructor")
@Getter @Setter
public class Instructor extends User{
    private String company;
}
