package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;
import io.erikrios.github.mynote.model.response.Response;
import io.erikrios.github.mynote.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping(
            value = "/api/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    public Response<CategoryResponse> saveCategory(@Valid @RequestBody CreateCategoryRequest request) {
        CategoryResponse response = service.insert(request);
        return new Response<>("success", null, response);
    }
}
