package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.events.form.EventForm;
import com.fapethedev.tendance.events.services.IDeliveryService;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/dashboard/deliveries")
@RequiredArgsConstructor
@Slf4j
public class MvcServiceController implements WebMvcConfigurer
{
    private final IDeliveryService deliveryService;
    private final IUserService userService;

    @GetMapping(value = {"", "/"})
    public String showEventPage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        var user = userService.findUserByEmail(authentication.getName());
        var deliveries = deliveryService.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("deliveries", deliveries);

        return "dashboard/service-list";
    }

    @GetMapping(value = {"/detail/{id}", "/detail/{id}"})
    public String showDetailsPage(Model model, Authentication authentication, @PathVariable(required = true) String id)
    {
        if (authentication == null) return "redirect:/login";

        var user = userService.findUserByEmail(authentication.getName());
//        var event = eventService.findById(UUID.fromString(id));

        model.addAttribute("user", user);
//        model.addAttribute("event", event);

        return "dashboard/event-detail";
    }

    @GetMapping(value = {"create/", "/create/"})
    public String showCreatePage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);
        model.addAttribute("eventForm", new EventForm());

        return "dashboard/service-add";
    }

    @PostMapping(value = {"create/", "/create/"})
    public String createEvent(@Valid @ModelAttribute("eventForm") EventForm form,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr)
    {

        if (result.hasErrors() || result.hasFieldErrors())
        {
            return "dashboard/service-add";
        }

        return "redirect:dashboard/service-list";
    }

    @GetMapping(value = {"update/{id}", "/update/{id}/"})
    public String showUpdatePage(Model model, Authentication authentication, @PathVariable String id)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        model.addAttribute("user", user);

        return "dashboard/service-list";
    }
}
