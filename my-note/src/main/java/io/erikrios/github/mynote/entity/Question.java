package io.erikrios.github.mynote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Question {

    @Id
    @Column(length = 50)
    private final String id;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(String question, List<Answer> answers) {
        id = UUID.randomUUID().toString();
        this.question = question;
        this.answers = answers;
    }

    public Question() {
        id = UUID.randomUUID().toString();
        question = "question";
        answers = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
