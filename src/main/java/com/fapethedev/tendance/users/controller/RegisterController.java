package com.fapethedev.tendance.users.controller;

import com.fapethedev.tendance.users.dto.UserDto;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.UserEmailService;
import com.fapethedev.tendance.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private final UserEmailService emailService;

    @Autowired
    public RegisterController(UserService userService, MessageSource i18n, UserEmailService emailService)
    {
        this.userService = userService;
        this.i18n = i18n;
        this.emailService = emailService;
    }

    @GetMapping(path = {"", "/", "/{id}", "/{id}/"})
    public String showRegisterForm(Model model, @PathVariable(required = false) final String id)
    {
        UserDto userDto = new UserDto();

        model.addAttribute("user", userDto);

        model.addAttribute("title", i18n.getMessage("dash.register.title", null, LocaleContextHolder.getLocale()));

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

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addFlashAttribute("user", user);
            attr.addFlashAttribute("errors", result.getFieldErrors());

            return "dashboard/register";
        }

        User newUser = userService.save(user);

//        emailService.sendRegisterConfirmationEmail(newUser);

        return "redirect:/register/success/" + newUser.getId();
    }

    @GetMapping(path = {"/success/{id}", "/success/{id}/"})
    public String showRegisterSuccesPage(Model model, @PathVariable(required = true) final String id)
    {
        User user = userService.findById(UUID.fromString(id));

        model.addAttribute("user", user);

        return "site/activate-account";
    }

    @GetMapping(path = {"/activate/{id}", "/activate/{id}/"})
    public String activateAccountAndShowDashboardPage(RedirectAttributes attr, @PathVariable(required = true) final String id)
    {
        User user = userService.findById(UUID.fromString(id));

        user.getAccount().setActive(true);

        user = userService.saveOrUpdate(user);

        attr.addAttribute("user", user);

        return "redirect:/dashboard/";
    }
}
