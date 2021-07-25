package io.erikrios.github.mynote.model.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateQuestionRequest {

    @NotBlank(message = "question field should be not blank")
    @NotNull(message = "question field should be not null")
    @Length(min = 2, max = 255)
    private String question;

    @NotBlank(message = "answers field should be not blank")
    @NotNull(message = "answers field should be not null")
    private List<CreateAnswerRequest> answers;

    public CreateQuestionRequest(String question, List<CreateAnswerRequest> answers) {
        this.question = question;
        this.answers = answers;
    }

    public CreateQuestionRequest() {
    }

    public String getQuestion() {
        return question;
    }

    public List<CreateAnswerRequest> getAnswers() {
        return answers;
    }
}
