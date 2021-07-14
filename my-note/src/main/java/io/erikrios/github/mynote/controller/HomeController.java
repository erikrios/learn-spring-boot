package io.erikrios.github.mynote.controller;

import io.erikrios.github.mynote.domain.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Response<String> getGreetingMessage() {
        return new Response<>("success", null, "Hello, World!");
    }
}
