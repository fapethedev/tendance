package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.security.facade.AuthenticationFacade;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.form.RegisterForm;
import com.fapethedev.tendance.users.publisher.UserEventPublisher;
import com.fapethedev.tendance.users.services.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * <p>Model view controller for user registration,
 * account activation and all relate operations.</p>
 *
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class MvcRegisterController implements WebMvcConfigurer
{
    private final IUserService userService;
    private final MessageSource i18n;
    private final AuthenticationFacade facade;
    private final UserEventPublisher publisher;

    @GetMapping(path = {"", "/", "/{id}", "/{id}/"})
    public String showRegisterForm(Model model, @PathVariable(required = false) final String id)
    {
        RegisterForm userForm = new RegisterForm();

        model.addAttribute("user", userForm);

        return "/dashboard/authentication-register";
    }

    @PostMapping(path = {"/save/", "/save", "/save{id}", "/save{id}/"})
    public String saveUser(@Valid @ModelAttribute("user") RegisterForm user,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr)
    {

        if (userService.existByEmail(user.getEmail()))
        {
            result.rejectValue("email", "", "Cet Adresse email est déja utilisé");
        }

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addFlashAttribute("user", user);
            attr.addFlashAttribute("errors", result.getFieldErrors());

            return "/dashboard/authentication-register";
        }

        User newUser = userService.save(user);

//        publisher.publishUserRegistrationEvent(newUser);

        return "redirect:/register/success/" + newUser.getId();
    }

    @GetMapping(path = {"/success/{id}", "/success/{id}/"})
    public String showRegisterSuccessPage(Model model, @PathVariable(required = true) final String id)
    {
        User user = userService.findById(UUID.fromString(id));

        model.addAttribute("user", user);

        return "site/activate-account";
    }

    @GetMapping(path = {"/activate/{id}", "/activate/{id}/"})
    public String activateAccount(HttpServletRequest req, RedirectAttributes attr, @PathVariable(required = true) final String id)
    {
        User user = userService.findById(UUID.fromString(id));
        attr.addFlashAttribute("user", user);

        if (user.isEnabled()) return "redirect:/dashboard/";

        user.getAccount().setActive(true);
        user.getAccount().setEmailVerified(true);

        user = userService.save(user);

        facade.authWithUsernamePassword(user, req);

        return "redirect:/dashboard/";
    }
}
