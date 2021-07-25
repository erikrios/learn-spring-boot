package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.error.QuestionNotFoundException;
import io.erikrios.github.mynote.model.request.CreateQuestionRequest;
import io.erikrios.github.mynote.model.response.QuestionResponse;
import io.erikrios.github.mynote.model.response.Response;
import io.erikrios.github.mynote.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.erikrios.github.mynote.utils.Status.SUCCESS;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping(
            value = "/api/categories/{categoryId}/questions",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Response<QuestionResponse> saveQuestion(
            @PathVariable("categoryId") String categoryId,
            @Valid @RequestBody CreateQuestionRequest request
    ) throws CategoryNotFoundException {
        QuestionResponse response = questionService.insert(categoryId, request);
        return new Response<>(SUCCESS, null, response);
    }

    @GetMapping(value = "/api/questions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<QuestionResponse> getCategoryById(@PathVariable("id") String id) throws QuestionNotFoundException {
        QuestionResponse response = questionService.findById(id);
        return new Response<>(SUCCESS, null, response);
    }
}
