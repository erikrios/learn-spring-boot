package io.erikrios.github.mynote.repository;

import io.erikrios.github.mynote.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, String> {

    List<Question> findByCategoryId(String categoryId);

    Optional<Question> findByIdAndCategoryId(String id, String categoryId);
}
