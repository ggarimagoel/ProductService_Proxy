package com.example.ProductServiceProxy.clients.fakestore.clients;

import com.example.ProductServiceProxy.clients.fakestore.dto.FakeStoreProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    //getting List of all productDtos using this facade
    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        return Arrays.asList(responseEntity.getBody()) ; // converting array to list
    }


}
/*
Basically here , we are the Clients of FakeStoreClient. We are using FakeStoreClient to get data from FakeStore.

Advantage of fakeStoreClient is that, we can do all the computation here instead of doing that in
fakeStoreServices . this is kind of facade we are building , that through this class fakeStoreServices will
be less cluttered.
 */