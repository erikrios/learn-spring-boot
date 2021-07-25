package io.erikrios.github.mynote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Category {

    @Id
    @Column(length = 50)
    private final String id;
    @Column(length = 25, nullable = false)
    private String name;

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
}
