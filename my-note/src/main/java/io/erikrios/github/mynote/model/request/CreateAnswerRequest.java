package io.erikrios.github.mynote.model.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateAnswerRequest {

    @NotBlank(message = "answer field should be not blank")
    @NotNull(message = "answer field should be not null")
    @Length(min = 2, max = 255)
    private String answer;

    @NotBlank(message = "isCorrect field should be not blank")
    @NotNull(message = "isCorrect field should be not null")
    private boolean isCorrect;

    public CreateAnswerRequest(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public CreateAnswerRequest() {
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
