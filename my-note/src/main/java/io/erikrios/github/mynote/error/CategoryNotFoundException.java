package io.erikrios.github.mynote.error;

public class CategoryNotFoundException extends Exception {
    private final String message;

    public CategoryNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
