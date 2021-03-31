package io.erikrios.github.springbootjournal;

import io.erikrios.github.springbootjournal.domain.Journal;
import io.erikrios.github.springbootjournal.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJournalApplication {

    @Bean
    InitializingBean saveData(JournalRepository repository) {
        return () -> {
            repository.save(new Journal("Get to know Spring Boot", "Today I will learn Spring Boot", "03/31/2021"));
            repository.save(new Journal("Simple Spring Boot Project", "I will do my first Spring Boot Project", "04/01/2021"));
            repository.save(new Journal("Spring Boot Reading", "Read more about Spring Boot", "04/01/2021"));
            repository.save(new Journal("Spring Boot In The Cloud", "Spring Boot using Cloud Foundry", "04/01/2021"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJournalApplication.class, args);
    }
}
