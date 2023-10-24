package com.example.ProductServiceProxy.inhertanceExamples.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "MappedSuperclass_Instructor")
@Getter @Setter

public class Instructor extends User {
    private String company;
}
