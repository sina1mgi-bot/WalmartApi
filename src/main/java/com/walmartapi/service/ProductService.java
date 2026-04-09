package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.manager.CustomObjectMapper;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CustomObjectMapper<ProductEntity, Product> productMapper;

    public ProductService (ProductRepository productRepository, CustomObjectMapper<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(Product product) {

        //producto a entity

        //genera con ese quary que ya trae el id

        ProductEntity newProduct = productMapper.mapToEntity(product);

        ProductEntity savedEntity = productRepository.save(newProduct);

        //entity a producto

        //map POJO to entity = una clase sin librerias ""
        //call BD
        //map entity to POJO


        return productMapper.mapToDto(savedEntity);
    }

    public Product getProductById(Long id){
        Optional<ProductEntity> product = productRepository.findById(id); //Optional: nos anade una capa mas apra ver si nuestro objeto es null

        if (product.isEmpty()){
            throw new NotFound("Product not found.");
        }

        return productMapper.mapToDto(product.get()); //si llega a ser null lanzsaría una NullPointException
    }

    @DeleteMapping()
    public Product deleteProduct(){
        productRepository.deleteById();
    }


}
