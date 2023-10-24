package com.example.ProductServiceProxy.services;

import com.example.ProductServiceProxy.clients.ClientProductDtoInterface;
import com.example.ProductServiceProxy.clients.fakestore.clients.FakeStoreClient;
import com.example.ProductServiceProxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.ProductServiceProxy.dtos.ProductDto;
import com.example.ProductServiceProxy.models.Categories;
import com.example.ProductServiceProxy.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Service
public class FakeStoreProductService implements ProductServiceInterface {
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder,FakeStoreClient fakeStoreClient){
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;

        //  restTemplateBuilder.rootUri("https://fakestoreapi.com/products");
        // this will be the base url for all the calls and we dont have to specify it in every call/service.
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url,
                                                  @Nullable Object request, Class<FakeStoreProductDto> responseType, Long uriVariables) throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url,httpMethod,requestCallback,responseExtractor,uriVariables);
    }

    @Override
    public List<Product> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<ProductDto[]> productDtos =
//                restTemplate.getForEntity( "https://fakestoreapi.com/products" ,ProductDto[].class );
//        ---- here we will use FakeStoreClient facade instead of above code------

        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();

        /*
        here we are using array instead of List because of generics i.e. in runtime List cannot figure out whether
        it contains integer, String or object , so we use array which specifies the type of data it contains.
        And later convert it into List.
         */
        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto productDto: fakeStoreProductDtos){
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            Categories category = new Categories();
            category.setName(productDto.getCategory());
            product.setImageUrl(productDto.getImageUrl());
            answer.add(product);
        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {

        //to get response from fake store api
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> productDto =
                restTemplate.getForEntity( "https://fakestoreapi.com/products/{id}" ,FakeStoreProductDto.class,productId );

        return getProduct(productDto.getBody());
    }

    // helper method to get product(return type to the client) from productDto(return type of fake store api)
    private static Product getProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        Categories category = new Categories();
        category.setName(fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImageUrl());
        return product;
    }
//    @Override
//    public Product addNewProduct(ClientProductDtoInterface productDto){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto,ProductDto.class);
        /*
        In above piece of code we are posting the product in fakestoreapi, If we want to store
         data in our own data base we can do dat with the help of repository.(refer SelfProductService)
         */
//        return getProduct((FakeStoreProductDto) productDto);
//    }

    @Override
    public Product addNewProduct(Product product) {
        /*
         this method is for saving the product to our own DB , so we will leave it empty here
         ans implement in self product service.
         */

        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ClientProductDtoInterface fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImageUrl(product.getImageUrl());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getName());

        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity
                         = requestForEntity(
                         HttpMethod.PATCH,
                        "https://fakestoreapi.com/products/{id}",
                        fakeStoreProductDto,
                        FakeStoreProductDto.class,
                        productId);

        FakeStoreProductDto fakeStoreProductDto1 = fakeStoreProductDtoResponseEntity.getBody();
        return getProduct(fakeStoreProductDto1);
    }
    @Override
    public String deleteProduct(Long productId){
        return "Delete product";
    }
}


/*
for DB we have to create a repository and then we have to create a service for that repository.
but here we will connect to fake store api so we will create a service for that api.

REST TEMPLATE is a library that helps us to make http calls to other services, in this case fake store api.
we are using RestTemplateBuilder bec we need to call different services(GET, POST, PUT, DELETE) and
RestTemplateBuilder helps us to do that.



in this line, we are calling the fake store api and getting the response in ProductDto object.
  ProductDto productDto =
    restTemplate.getForEntity( "https://fakestoreapi.com/products/{id}" ,ProductDto.class,productId ).getBody();

    {id} and productId:  {id} from /product in fake store will map to productId in our service.
    ProductDto.class: this is return type from the call made to fake store api.
    productId: this is the id of the product we want to get from fake store api.
    getBody(): this will return the body of the response we get from fake store api.
    productDto: this is the response we get from fake store api, but we should not expose fakestore
    object to the client,  we will return our Product.class obj to the client.
    to do that , we create a product obj by putting values of productDto into it(Hardcoding)

    i.e.
     Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = new Categories();
        category.setName(productDto.getCategory());
        product.setImageUrl(productDto.getImageUrl());
        return product;

    Although this is correct code but it violates SRP ,OCP, so better way is to use facade design pattern
    or using helper function.

 */