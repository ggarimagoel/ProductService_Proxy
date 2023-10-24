package com.example.ProductServiceProxy.inhertanceExamples.mappedSuperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "MappedSuperclass_Mentor") // this will privide the name of the table in the database
@Setter @Getter
public class Mentor extends User {
    private int gradYear;

}
