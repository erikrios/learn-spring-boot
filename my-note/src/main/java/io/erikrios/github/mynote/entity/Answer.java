package io.erikrios.github.mynote.entity;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
