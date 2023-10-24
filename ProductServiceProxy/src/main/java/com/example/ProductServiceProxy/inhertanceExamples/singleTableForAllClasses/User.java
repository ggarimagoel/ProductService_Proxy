package com.example.ProductServiceProxy.inhertanceExamples.singleTableForAllClasses;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "singleTable_User")
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type" , discriminatorType = DiscriminatorType.INTEGER)// we need to specify the name of the column that will be used to identify the type of the user
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
