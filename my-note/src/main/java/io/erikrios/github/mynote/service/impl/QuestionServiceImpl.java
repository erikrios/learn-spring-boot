package io.erikrios.github.mynote.service.impl;

import io.erikrios.github.mynote.entity.Answer;
import io.erikrios.github.mynote.entity.Category;
import io.erikrios.github.mynote.entity.Question;
import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.model.request.CreateAnswerRequest;
import io.erikrios.github.mynote.model.request.CreateQuestionRequest;
import io.erikrios.github.mynote.model.response.AnswerResponse;
import io.erikrios.github.mynote.model.response.QuestionResponse;
import io.erikrios.github.mynote.repository.CategoryRepository;
import io.erikrios.github.mynote.repository.QuestionRepository;
import io.erikrios.github.mynote.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository, CategoryRepository categoryRepository) {
        this.questionRepository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public QuestionResponse insert(String categoryId, CreateQuestionRequest request) throws CategoryNotFoundException {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found."));

        Question question = convertRequestToQuestion(request);
        question.setCategory(category);

        Question saved = questionRepository.save(question);
        return convertQuestionToResponse(saved);
    }

    private Question convertRequestToQuestion(CreateQuestionRequest request) {
        String question = request.getQuestion();
        List<CreateAnswerRequest> answerRequests = request.getAnswers();

        List<Answer> answers = new ArrayList<>();

        answerRequests.forEach(answerRequest ->
                answers.add(new Answer(answerRequest.getAnswer(), answerRequest.isCorrect()))
        );

        return new Question(question, answers);
    }

    private QuestionResponse convertQuestionToResponse(Question question) {
        String id = question.getId();
        String questionName = question.getQuestion();
        List<Answer> answers = question.getAnswers();
        List<AnswerResponse> answerResponses = answers.stream().map(answer ->
                new AnswerResponse(answer.getId(), answer.getAnswer(), answer.isCorrect())
        )
                .collect(Collectors.toList());
        return new QuestionResponse(id, questionName, answerResponses);
    }
}
