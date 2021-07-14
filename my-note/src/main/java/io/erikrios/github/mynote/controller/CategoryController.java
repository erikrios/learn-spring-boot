package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.model.request.CreateCategoryRequest;
import io.erikrios.github.mynote.model.response.CategoryResponse;
import io.erikrios.github.mynote.model.response.Response;
import io.erikrios.github.mynote.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static io.erikrios.github.mynote.utils.Status.SUCCESS;

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
        return new Response<>(SUCCESS, null, response);
    }

    @GetMapping(
            value = "/api/categories",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<List<CategoryResponse>> getAllCategory() {
        List<CategoryResponse> categoryResponses = service.findAll();
        return new Response<>(SUCCESS, null, categoryResponses);
    }
}
