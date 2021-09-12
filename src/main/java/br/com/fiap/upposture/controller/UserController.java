package br.com.fiap.upposture.controller;

import br.com.fiap.upposture.model.User;
import br.com.fiap.upposture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/signin")
    public String create(User user) {
        return "signin";
    }

    @PostMapping("/user")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()) return "signin";
        repository.save(user);
        return "login";
    }

    @RequestMapping("/login")
    public String find(User user) {
        return "login";
    }

    @PostMapping("/find")
    public String login(@Valid User user, BindingResult result) {
        if (result.hasErrors()) return "login";
        return "logado";
    }
}

