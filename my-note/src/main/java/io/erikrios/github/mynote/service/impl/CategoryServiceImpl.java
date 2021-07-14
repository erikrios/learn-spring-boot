package io.erikrios.github.mynote.service.impl;

import io.erikrios.github.mynote.entity.Category;
import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;
import io.erikrios.github.mynote.repository.CategoryRepository;
import io.erikrios.github.mynote.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CategoryResponse> findAll() {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        List<Category> categories = repository.findAll();

        categories.forEach(category -> categoryResponses.add(convertCategoryToResponse(category)));

        return categoryResponses;
    }

    private CategoryResponse convertCategoryToResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
