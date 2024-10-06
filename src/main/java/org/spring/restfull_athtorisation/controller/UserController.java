package org.spring.restfull_athtorisation.controller;

import lombok.RequiredArgsConstructor;
import org.spring.restfull_athtorisation.Model.User;
import org.spring.restfull_athtorisation.service.UserService;
import org.spring.restfull_athtorisation.service.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//curl -u username:password http://localhost:8080/api/admin
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/public")
    public String publicMethodGet() {
        return "Эта страница доступна для всех";
    }

    @GetMapping("/user")
    public String userMethodGet() {
        return "Эта страница доступна для юзеров";
    }

    @GetMapping("/admin")
    public String adminMethodGet() {
        return "Эта страница доступна для админов";
    }

    @GetMapping("/admin-moderator")
    public String adminModeratorMethodGet() {
        return "Эта страница доступна для админов и модераторов";
    }

    @GetMapping("/all-roles")
    public String allRolesMethodGet() {
        return "Эта страница доступна для авторизированных пользователей";
    }

    @PostMapping(value = "/create-account")
    public String createAccount(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getRoles());
        userService.saveUser(user);
        return "Account created successfully";
    }

}
