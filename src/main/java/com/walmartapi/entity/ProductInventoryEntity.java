package com.walmartapi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_inventory")
@Data
public class ProductInventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer stock;

    private String warehouseLocation;

    private LocalDateTime lastUpdate;

    @OneToOne(mappedBy = "inventory")
    /*
    Aqui no se hace la relación con los id sino con los objetos
     */
    private ProductEntity product;



}
