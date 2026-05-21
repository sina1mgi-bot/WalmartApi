package com.walmartapi.manager.impl;

import com.walmartapi.entity.CategoryEntity;
import com.walmartapi.manager.CustomObjectMapper;
import com.walmartapi.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements CustomObjectMapper<CategoryEntity, Category> {


    @Override
    public CategoryEntity mapToEntity(Category dto) {
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setDescription(dto.getDescription());
        categoryEntity.setName(dto.getName());
        categoryEntity.setId(dto.getId());

        return categoryEntity;
    }

    @Override
    public Category mapToDto(CategoryEntity entity) {
        Category savedCategory = new Category();

        savedCategory.setDescription(entity.getDescription());
        savedCategory.setName(entity.getName());
        savedCategory.setId(entity.getId());

        return savedCategory;
    }
}
