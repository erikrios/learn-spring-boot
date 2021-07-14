package io.erikrios.github.mynote.service.impl;

import io.erikrios.github.mynote.entity.Category;
import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;
import io.erikrios.github.mynote.repository.CategoryRepository;
import io.erikrios.github.mynote.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryResponse insert(CreateCategoryRequest request) {
        Category category = new Category(request.getName());
        Category saved = repository.save(category);
        return convertCategoryToResponse(saved);
    }

    private CategoryResponse convertCategoryToResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
