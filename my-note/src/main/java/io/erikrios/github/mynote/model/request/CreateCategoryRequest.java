package io.erikrios.github.mynote.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateCategoryRequest {
    @NotBlank(message = "name field should be not blank")
    @NotNull(message = "name field should be not null")
    @Length(min = 2, max = 25)
    @JsonProperty
    private String name;

    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public CreateCategoryRequest() {
    }

    public String getName() {
        return name;
    }
}
