package io.erikrios.github.springbootjournal.web;

import io.erikrios.github.springbootjournal.domain.Journal;
import io.erikrios.github.springbootjournal.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JournalController {

    @Autowired
    JournalRepository repository;

    @RequestMapping(value = "/journal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    List<Journal> getJournal() {
        return repository.findAll();
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("journal", repository.findAll());
        return "index";
    }
}
