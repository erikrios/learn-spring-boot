package io.erikrios.github.mynote.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @Column(length = 50)
    private final String id;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Question> questions;

    public Category(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Category() {
        this.id = UUID.randomUUID().toString();
        this.name = "No Name";
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
