package com.example.ProductServiceProxy.inhertanceExamples.joinedTables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TablePerClass_User")
@Getter @Setter
@Inheritance(strategy = InheritanceType.JOINED) // specify the inheritance strategy
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
}
