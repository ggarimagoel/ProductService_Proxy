package com.example.ProductServiceProxy.clients.fakestore.dto;
import com.example.ProductServiceProxy.clients.ClientProductDtoInterface;
import com.example.ProductServiceProxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class FakeStoreProductDto extends ClientProductDtoInterface {

}

// currently our fakestoreDto and SelfDto are same.