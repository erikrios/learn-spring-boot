package io.erikrios.github.mynote.service;

import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;

public interface CategoryService {

    CategoryResponse insert(CreateCategoryRequest request);
}
