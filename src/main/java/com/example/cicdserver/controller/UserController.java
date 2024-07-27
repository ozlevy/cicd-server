package com.example.cicdserver.controller;

import com.example.cicdserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
        return "User created";
    }

    @PutMapping("/update/{id}")
    public String updateUserPassword(@PathVariable Long id, @RequestParam String password) {
        userService.updateUserPassword(id, password);
        return "User password updated";
    }
}
