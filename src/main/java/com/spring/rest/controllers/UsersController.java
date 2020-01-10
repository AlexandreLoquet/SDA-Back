package com.spring.rest.controllers;


import com.spring.rest.entities.Users;
import com.spring.rest.repositories.UsersRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){ this.usersRepository = usersRepository; }

    @GetMapping("/all")
    List<Users> allUsers() { return usersRepository.findAll(); }
}
