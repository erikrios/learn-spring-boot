package io.erikrios.github.mynote.model.response;

public class CategoryResponse {

    private final String id;
    private final String name;

    public CategoryResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
