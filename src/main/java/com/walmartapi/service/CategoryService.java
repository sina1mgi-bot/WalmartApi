package com.walmartapi.service;

import com.walmartapi.entity.CategoryEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.manager.impl.CategoryMapper;
import com.walmartapi.model.Category;
import com.walmartapi.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public Category savedCategory(Category category){

        CategoryEntity newCategory = categoryMapper.mapToEntity(category);
        CategoryEntity savedEntity = categoryRepository.save(newCategory);

        return categoryMapper.mapToDto(savedEntity);
    }

    public Category findById(Long id){

        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isEmpty()){
            throw new NotFound("Categoría no encontrada");
        }

        return categoryMapper.mapToDto(foundCategory.get());

    }

    public CategoryEntity findEntityById(Long id){
        Optional<CategoryEntity> foundCategory = categoryRepository.findById(id);

        if (foundCategory.isEmpty()){
            throw new NotFound("Categoria no encontrada");
        }
        return foundCategory.get();
    }



}
