package com.example.ProductServiceProxy.inhertanceExamples.joinedTables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "joinedTable_Instructor")
@Getter @Setter
@PrimaryKeyJoinColumn(name = "user_id")

public class Instructor extends User {
    private String company;
}
