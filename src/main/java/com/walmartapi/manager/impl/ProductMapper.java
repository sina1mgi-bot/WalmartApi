package com.walmartapi.manager.impl;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.manager.CustomObjectMapper;
import com.walmartapi.model.Product;
import org.springframework.stereotype.Component;

@Component //se especifica con la notacion
public class ProductMapper implements CustomObjectMapper<ProductEntity, Product> {
    //Dto es una clase que solo mueve información a través de las capas
    //Dao los objetos que se conectan a la base de datos


    @Override
    public ProductEntity mapToEntity(Product dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return productEntity;
    }

    @Override
    public Product mapToDto(ProductEntity entity) {
        Product savedProduct = new Product();
        savedProduct.setName(entity.getName());
        savedProduct.setDescription(entity.getDescription());
        savedProduct.setPrice(entity.getPrice());
        savedProduct.setId(entity.getId());
        return savedProduct;
    }
}
