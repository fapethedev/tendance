package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.security.form.ResetPasswordForm;
import com.fapethedev.tendance.security.form.UpdatePasswordForm;
import com.fapethedev.tendance.security.publisher.PasswordEventPublisher;
import com.fapethedev.tendance.users.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping({"/login", "/login/"})
@RequiredArgsConstructor
public class MvcPasswordController
{
    private final IUserService userService;
    private final MessageSource i18n;
    private final PasswordEventPublisher passwordEventPublisher;

    @GetMapping({"forgot-password/", "/forgot-password/{id}",
            "/forgot-password/", "/forgot-password/{id}/"})
    public String showPwdForgotPage(Model model,  @PathVariable(required = false) final String id)
    {
        model.addAttribute("reset", new ResetPasswordForm());

        return "dashboard/authentication-forgot-password";
    }

    @PostMapping({"/forgot-password/ask-password-reset", "/forgot-password/ask-password-reset/{id}",
            "/forgot-password/ask-password-reset/", "/forgot-password/ask-password-reset/{id}/"})
    public String sendPwdForgotRequest(@Valid @ModelAttribute("reset") ResetPasswordForm reset,
                                       final BindingResult result,
                                       @PathVariable(required = false) final String id,
                                       final RedirectAttributes attr)
    {
        var email = reset.getEmail();

        if (!userService.existByEmail(email)){
            result.rejectValue("email", "", "L'adresse email " + email + " ne possede pas de compte");
        }

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addFlashAttribute("reset", reset);
            attr.addFlashAttribute("errors", result.getFieldErrors());

            return "dashboard/authentication-forgot-password";
        }

        attr.addAttribute("reset", reset);

        return "redirect:site/reset-password";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/dashboard/settings/update-password", "dashboard/settings/update-password",
            "/dashboard/settings/update-password/{id}", "dashboard/settings/update-password/{id}/"})
    public String savePassword(@Valid @ModelAttribute("passwordUpdate") UpdatePasswordForm updatePasswordForm,
                               final BindingResult result,
                               @PathVariable(required = false) final String id,
                               final ModelMap attr)
    {
        String newPassword = updatePasswordForm.getNewPassword(),
                confirmPassword = updatePasswordForm.getConfirmPassword(),
                currentPassword = updatePasswordForm.getCurrentPassword();

        if (newPassword.compareTo(confirmPassword) != 0)
        {
            result.rejectValue("confirmPassword", "",
                    "Veuillez entrez la même valeur pour les deux champs mot de passe");
        }

        if (result.hasErrors() || result.hasFieldErrors())
        {
            attr.addAttribute("errors", result.getFieldErrors())
                    .addAttribute("updatePasswordDto", updatePasswordForm);

            return "redirect:/dashboard/settings/";
        }

        passwordEventPublisher.publishPasswordChangeEvent(userService.findById(UUID.fromString(id)), updatePasswordForm);

        return "redirect:/register";
    }
}
