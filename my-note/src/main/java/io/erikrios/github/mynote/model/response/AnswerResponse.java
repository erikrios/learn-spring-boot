package io.erikrios.github.mynote.model.response;

public class AnswerResponse {

    private final String id;
    private final String answer;
    private final boolean isCorrect;

    public AnswerResponse(String id, String answer, boolean isCorrect) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
