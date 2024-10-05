package org.spring.restfull_athtorisation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//curl -u username:password http://localhost:8080/api/admin
@RestController
@RequestMapping(value = "/api")
public class UserController {

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

    @GetMapping("/admin-user")
    public String adminUserMethodGet() {
        return "Эта страница доступна для админов и юзеров";
    }

    @GetMapping("/all-roles")
    public String allRolesMethodGet() {
        return "Эта страница доступна для авторизированных пользователей";
    }


}
