package com.example.springsecuritybootstrap.contoller;


import com.example.springsecuritybootstrap.entity.User;
import com.example.springsecuritybootstrap.service.RoleService;
import com.example.springsecuritybootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String getHomePage() {

        return "index";
    }

    @GetMapping("/admin")
    public String getAdminPage(Principal principal, Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("authenticatedUser", userService.getByUserName(principal.getName()).get());
        model.addAttribute("allRoles", roleService.getAll());
        return "admin";
    }

    @PostMapping("/admin/create")
    public String saveUser(@ModelAttribute("user") User user) {
        System.out.println(user.getFirstName());
        userService.save(user);
        return "redirect:/admin";
    }

    @PostMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userId) {
        userService.delete(userId);
        return "redirect:/admin";
    }

    @PostMapping("admin/update/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

}
