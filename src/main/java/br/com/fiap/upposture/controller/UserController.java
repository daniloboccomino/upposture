package br.com.fiap.upposture.controller;

import br.com.fiap.upposture.model.User;
import br.com.fiap.upposture.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/signin")
    public String create(User user) {
        return "signin";
    }

    @PostMapping("/user")
    public String save(@Valid User user, BindingResult result) {
        System.out.println(result.toString());
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
        System.out.println(result.toString());
        if (result.hasErrors()) return "login";
        if (repository.findByEmailAndPassword(user.getEmail(), user.getPassword()).isEmpty() ) return "login";

        return "home";
    }
}

