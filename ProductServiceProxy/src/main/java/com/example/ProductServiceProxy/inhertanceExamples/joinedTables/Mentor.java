package com.example.ProductServiceProxy.inhertanceExamples.joinedTables;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "joinedTable_Mentor") // this will privide the name of the table in the database
@PrimaryKeyJoinColumn(name = "user_id")

public class Mentor extends User {
    private int gradYear;

}
