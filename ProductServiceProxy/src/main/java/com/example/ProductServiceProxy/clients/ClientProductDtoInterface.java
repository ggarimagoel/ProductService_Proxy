package com.example.ProductServiceProxy.clients;

import com.example.ProductServiceProxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public abstract class  ClientProductDtoInterface {
     Long id;
     String title;
     String description;
     double price;
     String category;
     String imageUrl;
     RatingDto rating;
}



/*
This abs class  is required because todau there is fakestoreDto but tomorrow there can be another dto
 from another client.

 We should never expose ClientsDto to the outside world. That is we can never expose models of fakestore to our
 Clients.
 */