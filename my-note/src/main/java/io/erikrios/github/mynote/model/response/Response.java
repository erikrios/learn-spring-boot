package io.erikrios.github.mynote.model.response;

import java.util.List;

public class Response<T> {
    private final String status;
    private final List<String> message;
    private final T data;

    public Response(String status, List<String> message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
