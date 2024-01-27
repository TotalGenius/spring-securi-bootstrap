package com.example.springsecuritybootstrap.contoller;


import com.example.springsecuritybootstrap.entity.User;
import com.example.springsecuritybootstrap.service.RoleService;
import com.example.springsecuritybootstrap.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/user")
    public String getUserInfo(Principal principal, Model model) {
        User user = userService.getByUserName(principal.getName()).get();
        model.addAttribute("authenticatedUser", user);
        model.addAttribute("allRoles", roleService.getAll());
        return "user";
    }
}
