package io.erikrios.github.mynote.service.impl;

import io.erikrios.github.mynote.entity.Answer;
import io.erikrios.github.mynote.entity.Category;
import io.erikrios.github.mynote.entity.Question;
import io.erikrios.github.mynote.error.CategoryNotFoundException;
import io.erikrios.github.mynote.model.request.CreateAnswerRequest;
import io.erikrios.github.mynote.model.request.CreateQuestionRequest;
import io.erikrios.github.mynote.model.response.AnswerResponse;
import io.erikrios.github.mynote.model.response.QuestionResponse;
import io.erikrios.github.mynote.repository.AnswerRepository;
import io.erikrios.github.mynote.repository.CategoryRepository;
import io.erikrios.github.mynote.repository.QuestionRepository;
import io.erikrios.github.mynote.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final CategoryRepository categoryRepository;
    private final AnswerRepository answerRepository;

    Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

    @Autowired
    public QuestionServiceImpl(
            QuestionRepository repository,
            CategoryRepository categoryRepository,
            AnswerRepository answerRepository) {
        this.questionRepository = repository;
        this.categoryRepository = categoryRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public QuestionResponse insert(String categoryId, CreateQuestionRequest request) throws CategoryNotFoundException {
        logger.info(request.toString());
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryId + " not found."));

        Question question = convertRequestToQuestion(request, category);

        Question savedQuestion = questionRepository.save(question);

        List<Answer> savedAnswers = answerRepository.saveAll(convertRequestToAnswers(request.getAnswers(), savedQuestion));
        savedQuestion.setAnswers(savedAnswers);

        return convertQuestionToResponse(savedQuestion);
    }

    private Question convertRequestToQuestion(CreateQuestionRequest request, Category category) {
        String question = request.getQuestion();
        return new Question(question, category);
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

    private List<Answer> convertRequestToAnswers(List<CreateAnswerRequest> requests, Question question) {
        return requests
                .stream()
                .map(request ->
                        new Answer(request.getAnswer(), request.isCorrect(), question)
                ).collect(Collectors.toList());
    }

    private List<CreateAnswerRequest> convertAnswersToRequest(List<Answer> answers) {
        return answers
                .stream()
                .map(answer ->
                        new CreateAnswerRequest(answer.getAnswer(), answer.isCorrect())
                ).collect(Collectors.toList());
    }
}
