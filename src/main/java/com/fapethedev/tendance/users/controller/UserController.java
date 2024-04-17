package com.fapethedev.tendance.users.controller;

import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class UserController implements WebMvcConfigurer
{
    private final UserService userService;
    private final MessageSource i18n;

    @Autowired
    public UserController(UserService userService, MessageSource i18n) {
        this.userService = userService;
        this.i18n = i18n;
    }

    @GetMapping(path = {"/dashboard/profile/", "dashboard/profile/", "dashboard/profile", "dashboard/profile"})
    public String showProfilePage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        model.addAttribute("title", "Profile");

        return "dashboard/page-user-profile";
    }
}
