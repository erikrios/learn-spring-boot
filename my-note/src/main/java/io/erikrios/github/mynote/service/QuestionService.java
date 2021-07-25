package io.erikrios.github.mynote.service;

import io.erikrios.github.mynote.model.request.CreateQuestionRequest;
import io.erikrios.github.mynote.model.response.QuestionResponse;

public interface QuestionService {

    QuestionResponse insert(CreateQuestionRequest request);
}
