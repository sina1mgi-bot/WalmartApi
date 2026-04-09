package com.walmartapi.repository;


import com.walmartapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> { //solo definimos los métodos
    //ya se encarga dentro de springboot de hacer las implemenataciones, ya trae los métodos

    //mapear objetos es agarrar atributos y crear un objeto de otro objeto



}
