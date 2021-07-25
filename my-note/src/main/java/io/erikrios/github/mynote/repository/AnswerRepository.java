package io.erikrios.github.mynote.repository;

import io.erikrios.github.mynote.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, String> {
}
