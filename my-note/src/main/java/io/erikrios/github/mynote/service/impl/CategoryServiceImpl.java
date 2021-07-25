package io.erikrios.github.mynote.service.impl;

import io.erikrios.github.mynote.entity.Category;
import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;
import io.erikrios.github.mynote.repository.CategoryRepository;
import io.erikrios.github.mynote.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public CategoryResponse findById(String id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = repository.findById(id);
        if (!optionalCategory.isPresent())
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        return convertCategoryToResponse(optionalCategory.get());
    }

    private CategoryResponse convertCategoryToResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }

    @Override
    public CategoryResponse update(String id, CreateCategoryRequest request) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = repository.findById(id);
        if (!optionalCategory.isPresent())
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        Category category = optionalCategory.get();
        category.setName(request.getName());
        repository.save(category);
        return convertCategoryToResponse(category);
    }

    @Override
    public CategoryResponse delete(String id) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = repository.findById(id);
        if (!optionalCategory.isPresent())
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        Category category = optionalCategory.get();
        repository.delete(category);
        return convertCategoryToResponse(category);
    }
}
