package io.erikrios.github.mynote.service;

import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse insert(CreateCategoryRequest request);

    List<CategoryResponse> findAll();

    CategoryResponse findById(String id) throws CategoryNotFoundException;
}
