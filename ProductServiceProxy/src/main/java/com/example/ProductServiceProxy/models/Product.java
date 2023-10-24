package com.example.ProductServiceProxy.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter @Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private double price;
    @ManyToOne(cascade= CascadeType.ALL)
    private Categories category;
    private String imageUrl;

}

/*
In Product.class we have category as an object of Categories class, but in ProductDto.class
we have category as a string(as per specified in fake store api).

(cascade= CascadeType.ALL) this is used to save related model , here categories in database automatically,
so that we can save product.
 */