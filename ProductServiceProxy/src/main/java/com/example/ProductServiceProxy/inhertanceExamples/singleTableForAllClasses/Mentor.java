package com.example.ProductServiceProxy.inhertanceExamples.singleTableForAllClasses;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "singleTable_Mentor") // this will privide the name of the table in the database
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private int gradYear;

}
