package com.walmartapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity //reoresentacion de una tabla en una base de datos
@Table(name = "products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @OneToOne(cascade = CascadeType.ALL) //le indican a sprinboot
    // que nosolo afecte a la que inyecta sino
    //la que hereda
    @JoinColumn(name = "inventory_id", unique = true)
    private ProductInventoryEntity inventory;


}
