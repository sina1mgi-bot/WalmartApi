package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(product.getDescription());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());

        ProductEntity savedEntity = productRepository.save(productEntity);//genera con ese quary que ya trae el id


        product.setName(savedEntity.getName());
        product.setDescription(savedEntity.getDescription());
        product.setPrice(savedEntity.getPrice());
        product.setId(savedEntity.getId());


        //map POJO to entity = una clase sin librerias ""
        //call BD
        //map entity to POJO


        return product;
    }

}
