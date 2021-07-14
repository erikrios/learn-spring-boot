package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.domain.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${greeting.message}")
    private String greetingMessage;

    @GetMapping("/")
    public Response<String> getGreetingMessage() {
        return new Response<>("success", null, greetingMessage);
    }
}
