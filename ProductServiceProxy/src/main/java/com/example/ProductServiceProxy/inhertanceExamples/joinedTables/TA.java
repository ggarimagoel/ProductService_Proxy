package com.example.ProductServiceProxy.inhertanceExamples.joinedTables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity(name = "joinedTable_TA") // this will privide the name of the table in the database
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {
    private double rating;
}
