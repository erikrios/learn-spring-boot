package io.erikrios.github.mynote.model.response;

import java.util.List;

public class QuestionResponse {

    private final String id;
    private final String question;
    private final List<AnswerResponse> answers;

    public QuestionResponse(String id, String question, List<AnswerResponse> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<AnswerResponse> getAnswers() {
        return answers;
    }
}
