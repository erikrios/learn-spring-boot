package io.erikrios.github.mynote.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Answer {

    @Id
    @Column(length = 50)
    private final String id;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer(String answer, boolean isCorrect) {
        id = UUID.randomUUID().toString();
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Answer() {
        id = UUID.randomUUID().toString();
        answer = "answer";
        isCorrect = false;
    }

    public String getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
