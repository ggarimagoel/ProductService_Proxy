package com.example.ProductServiceProxy.inhertanceExamples.seperateTablesForAllClasses;

import jakarta.persistence.Entity;

@Entity(name = "TablePerClass_Mentor") // this will privide the name of the table in the database
public class Mentor extends User{
    private int gradYear;

}
