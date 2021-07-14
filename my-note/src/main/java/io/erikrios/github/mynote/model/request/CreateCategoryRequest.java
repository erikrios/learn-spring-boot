package io.erikrios.github.mynote.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateCategoryRequest {
    @NotBlank
    @NotNull
    private final String name;

    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
