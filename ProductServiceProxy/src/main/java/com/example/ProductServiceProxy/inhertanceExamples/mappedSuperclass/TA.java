package com.example.ProductServiceProxy.inhertanceExamples.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "MappedSuperclass_TA") // this will privide the name of the table in the database
public class TA extends User {
    private double rating;
}
