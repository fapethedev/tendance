package com.fapethedev.tendance.users.controller;

import com.fapethedev.tendance.users.dto.UserDto;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/register")
public class RegisterController implements WebMvcConfigurer
{
    private UserService userService;
    private final MessageSource i18n;

    @Autowired
    public RegisterController(UserService userService, MessageSource i18n)
    {
        this.userService = userService;
        this.i18n = i18n;
    }

    @GetMapping(path = {"/", "/{id}", "/{id}/"})
    public String showRegisterForm(Model model, @PathVariable(required = false) final String id)
    {
        UserDto userDto = new UserDto();

        model.addAttribute("user", userDto);

        return "dashboard/register";
    }

    @PostMapping(path = {"/save/", "/save", "/save{id}", "/save{id}/"})
    public String saveUser(@Valid @ModelAttribute("user") UserDto user,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr)
    {

        User existingUser = userService.findUserByEmail(user.getEmail());

        if (existingUser != null)
        {
            result.rejectValue("email", "", "Cet Adresse email est déja utilisé");
        }

        if (user.getPassword().length() < 8)
        {
            result.rejectValue("password", "", "Le mot de passe doit contenir 8 charactere minimum");
        }

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addFlashAttribute("user", user);
            attr.addFlashAttribute("errors", result.getFieldErrors());

            return "dashboard/register";
        }

        User newUser = userService.save(user);

        return "redirect:/register/activate/" + newUser.getId();
    }

    @GetMapping(path = {"/activate/{id}", "/activate/{id}/"})
    public String showRegisterSuccesPage(Model model, @PathVariable(required = true) final String id)
    {
        User user = userService.findById(UUID.fromString(id));

        model.addAttribute("user", user);

        return "site/activate-account";
    }
}
