package com.fapethedev.tendance.users.controller;

import com.fapethedev.tendance.security.manager.UserLoginManager;
import com.fapethedev.tendance.users.dto.PasswordDto;
import com.fapethedev.tendance.users.dto.UserDto;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.UserEmailService;
import com.fapethedev.tendance.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class UserController implements WebMvcConfigurer
{
    private final UserService userService;
    private final MessageSource i18n;
    private final UserLoginManager userLoginManager;
    private final UserEmailService userEmailService;

    @Autowired
    public UserController(UserService userService, MessageSource i18n, UserLoginManager userLoginManager, UserEmailService userEmailService) {
        this.userService = userService;
        this.i18n = i18n;
        this.userLoginManager = userLoginManager;
        this.userEmailService = userEmailService;
    }

    @GetMapping(path = {"/dashboard/profile/", "dashboard/profile/", "dashboard/profile", "/dashboard/profile"})
    public String showProfilePage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        model.addAttribute("title", "Profile");

        return "dashboard/page-user-profile";
    }

    @GetMapping(path = {"/dashboard/settings/", "dashboard/settings/", "dashboard/settings", "/dashboard/settings"})
    public String showSettingsPage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        PasswordDto passwordDto = new PasswordDto();

        UserDto userDto = new UserDto();

        List<User.UserType> userTypes = List.of(User.UserType.STANDARD,
                User.UserType.ORGANIZER,
                User.UserType.SPONSOR,
                User.UserType.SERVICES_PROVIDER);

        model.addAttribute("user", user)
                .addAttribute("passwordUpdate", passwordDto)
                .addAttribute("userUpdate", userDto)
                .addAttribute("userTypes", userTypes)
                .addAttribute("title", "Paramètre");

        return "dashboard/page-account-settings";
    }

    @PostMapping(path = {"/dashboard/settings/update-password", "dashboard/settings/update-password",
            "/dashboard/settings/update-password/", "dashboard/settings/update-password/"})
    public String savePassword(@Valid @ModelAttribute("passwordUpdate") PasswordDto passwordDto,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr)
    {
        String newPassword = passwordDto.getNewPassword(),
                confirmPassword = passwordDto.getConfirmPassword(),
                currentPassword = passwordDto.getCurrentPassword();

        if (!newPassword.equals(confirmPassword))
        {
            result.rejectValue("confirmPassword", "",
                    "Veuillez entrez la même valeur pour les deux champs mot de passe");
        }

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addFlashAttribute("passwordUpdate", passwordDto);
            attr.addFlashAttribute("errors", result.getFieldErrors());

            return "redirect:dashboard/settings/";
        }

        userLoginManager.changePassword(currentPassword, newPassword);

        return "dashboard/page-account-settings";
    }

}
