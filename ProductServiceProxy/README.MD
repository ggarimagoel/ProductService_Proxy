
1#
Services can return models bec both services and models(Product) are internal to the app.
But controllers cannot return models bec they interact with the client, so controllers return DTOs.
public Product getSingleProduct(Long productId) {

@Override
        public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDto> productDto =
        restTemplate.getForEntity( "https://fakestoreapi.com/products/{id}" ,ProductDto.class,productId );
        return getProduct(productDto.getBody());
        }
    

2#
Here , when we connect to fakestoreapi.com through service layer, it returns a model/product(ProductDto.class) to us.
so basically ProductDto is a model of fakestoreapi.com. 


3#
We cannot return to model(ProductDto) of fakestoreapi.com from controller to the client, because that model
might change at any given point of time ,the properties may be added or deleted etc.

4#
fakestoreProductDto and SelfProductDto can be different , fakestoreProductDto is very specific to fakestoreapi.com
and SelfProductDto is specific to our app.so as a standard practice we should have seperate Dto for
fakestoreapi.com and our app.


5#
here fakestoeapi.com is also a third party ,  tommorrow thre can be some other third party, so we make an interface
of third party and implement it in a Dtoclass. so that we can easily switch between third parties.
hence FakeStoreProductDto  implements of ClientProductDtoInterface.

6#
FakeStorePRoductService is returning FakeStoreProductDto and rightly so.But our service layer can return Product/model
because it is internal to our app and our controller can return ProductDto because it interacts with the client.
