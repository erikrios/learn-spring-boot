package io.erikrios.github.mynote.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateQuestionRequest {

    @NotBlank(message = "question field should be not blank")
    @NotNull(message = "question field should be not null")
    @Length(min = 2, max = 255)
    @JsonProperty
    private String question;

    @Size(min = 2, max = 6)
    @JsonProperty
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

    @Override
    public String toString() {
        return "CreateQuestionRequest{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
