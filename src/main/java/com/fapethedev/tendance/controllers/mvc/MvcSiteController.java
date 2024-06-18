package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.main.form.ContactForm;
import com.fapethedev.tendance.security.form.LoginForm;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <p>Main site controller with the role to show site pages
 * and all interactions, this controller is different as other has mission to work
 * on the client and administrator dashboard.</p>
 *
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class MvcSiteController implements WebMvcConfigurer
{
    private final MessageSource i18n;
    private final IUserService userService;

    @Autowired
    public MvcSiteController(MessageSource i18n, IUserService userService) {
        this.i18n = i18n;
        this.userService = userService;
    }

    @GetMapping
    public String showMainPage(Model model)
    {
        model.addAttribute("title", "Accueil");
        return "site/index";
    }

    @GetMapping(path = "/events")
    public String showEventPage(Model model)
    {
        model.addAttribute("title", "Evènements");
        return "site/events";
    }

    @GetMapping(path = "/contact")
    public String showContactPage(Model model)
    {
        model.addAttribute("title", "Contact");
        model.addAttribute("contact", new ContactForm());
        return "site/contact";
    }

    @GetMapping(path = "/about")
    public String showAboutPage(Model model)
    {
        model.addAttribute("title", "À Propos");
        return "site/about";
    }

    @GetMapping(path = "/faq")
    public String showFaqPage(Model model)
    {
        model.addAttribute("title", "FAQ");
        return "site/faq";
    }

    @GetMapping(path = "/cart")
    public String showCartPage(Model model)
    {
        model.addAttribute("title", "Panier");
        return "site/cart";
    }

    @GetMapping(path = {"/login", "/login/"})
    public String showLoginPage(Model title, LoginForm user)
    {
        title.addAttribute("title", i18n.getMessage("dash.login.title", null, LocaleContextHolder.getLocale()));
        title.addAttribute("user", user);

        return "dashboard/authentication-login";
    }

    @GetMapping(path = {"/dashboard", "/dashboard/"})
    public String showAccountPage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        model.addAttribute("title", "Dashboard");

        return "dashboard/index";
    }


    @PostMapping(path = {"/contact/process", "/contact/process/", "contact/process/", "contact/process"})
    public String processContact(@Valid @ModelAttribute("contact") ContactForm contactForm,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr) {

        return "redirect:/contact";
    }
}
