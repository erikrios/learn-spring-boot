package io.erikrios.github.mynote.repository;

import io.erikrios.github.mynote.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
