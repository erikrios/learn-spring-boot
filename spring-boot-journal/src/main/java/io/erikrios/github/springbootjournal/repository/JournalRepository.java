package io.erikrios.github.springbootjournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.erikrios.github.springbootjournal.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {}
