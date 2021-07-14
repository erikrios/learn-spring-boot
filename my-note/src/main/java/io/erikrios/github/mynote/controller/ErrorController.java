package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.model.response.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.erikrios.github.mynote.utils.Status.ERROR;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new Response<>(ERROR, errors, null);
    }

    @ExceptionHandler(value = {CategoryNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<String> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        List<String> errors = new ArrayList<>();
        errors.add(exception.getMessage());
        return new Response<>(ERROR, errors, null);
    }
}
