package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.security.form.UpdatePasswordForm;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.form.UserForm;
import com.fapethedev.tendance.users.publisher.UserEventPublisher;
import com.fapethedev.tendance.users.services.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Controller
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class MvcUserController implements WebMvcConfigurer
{
    private final IUserService userService;
    private final UserEventPublisher userEventPublisher;
    private final MessageSource i18n;

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
    public String showSettingsPage(ModelMap model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        List<User.Type> types = List.of(User.Type.STANDARD,
                User.Type.ORGANIZER,
                User.Type.SPONSOR,
                User.Type.SERVICES_PROVIDER);

        model.addAttribute("user", user)
                .addAttribute("userTypes", types)
                .addAttribute("passwordUpdate", new UpdatePasswordForm())
                .addAttribute("userUpdate", new UserForm())
                .addAttribute("title", "Paramètres");

        return "dashboard/page-account-settings";
    }

}
