package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping(value = "/dashboard/calendar")
@RequiredArgsConstructor
@Slf4j
public class MvcCalendarController implements WebMvcConfigurer
{
    private final IUserService userService;

    @GetMapping(value = {"", "/"})
    public String showEventPage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        return "dashboard/app-calendar";
    }

}

