package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.events.entities.EventState;
import com.fapethedev.tendance.events.form.EventForm;
import com.fapethedev.tendance.events.services.IEventService;
import com.fapethedev.tendance.security.facade.AuthenticationFacade;
import com.fapethedev.tendance.users.entities.User;
import com.fapethedev.tendance.users.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.util.StringUtils;

import java.util.UUID;

/**
 * <p>Model view controller for events
 * on the dashboard and maybe more.</p>
 *
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 *
 * @author <a href="https://github.com/fapethedev">Fapethedev</a>
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/dashboard/events")
@RequiredArgsConstructor
@Slf4j
public class MvcEventController implements WebMvcConfigurer
{
    private final IEventService eventService;
    private final IUserService userService;
    private final AuthenticationFacade facade;

    @GetMapping(value = {"", "/"})
    public String showEventPage(Model model, Authentication authentication)
    {
        if (authentication == null) return "redirect:/login";

        var user = userService.findUserByEmail(authentication.getName());
        var events = eventService.findByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("events", events);

        return "dashboard/event-list";
    }

    @GetMapping(value = {"/detail/{id}", "/detail/{id}"})
    public String showDetailsPage(Model model, Authentication authentication, @PathVariable(required = true) String id)
    {
        if (authentication == null) return "redirect:/login";

        var user = userService.findUserByEmail(authentication.getName());
        var event = eventService.findById(UUID.fromString(id));

        model.addAttribute("user", user);
        model.addAttribute("event", event);

        return "dashboard/event-detail";
    }

    @GetMapping(value = {"/save", "/save/", "/save/{id}", "/save/{id}"})
    public String showCreatePage(Model model, Authentication authentication, @PathVariable(required = false) String id)
    {
        if (authentication == null) return "redirect:/login";

        User user = userService.findUserByEmail(authentication.getName());

        if (StringUtils.isEmptyOrWhitespace(id))
        {
            model.addAttribute("title", "Nouveau");
            model.addAttribute("action", "Créer");
        }
        else
        {
            model.addAttribute("title", "Modifier");
            model.addAttribute("action", "Modifier");
        }

        model.addAttribute("user", user);

        if (id == null || id.isEmpty())
        {
            model.addAttribute("eventForm", new EventForm());
        }
        else
        {
            var event = eventService.findById(UUID.fromString(id));
            var form = EventForm.builder()
                    .name(event.getName())
                    .description(event.getDescription())
                    .startDateTime(event.getStartDateTime())
                    .endDateTime(event.getEndDateTime())
                    .scope(event.getScope())
                    .build();

            model.addAttribute("eventForm", form);
        }

        return "dashboard/event-add";
    }

    @GetMapping(value = {"/delete/{id}", "/delete/{id}"})
    public String deleteEvent(Model model, Authentication authentication, @PathVariable(required = true) String id)
    {
        if (authentication == null) return "redirect:/login";

        eventService.delete(eventService.findById(UUID.fromString(id)));

        return "redirect:/dashboard/events";
    }

    @PostMapping(
            value = {"/save", "/save/", "/save/{id}", "/save/{id}/" },
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    public String createEvent(@Valid @ModelAttribute("eventForm") EventForm form,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final ModelMap attr)
    {
        var user = userService.findUserByEmail(facade.getAuthentication().getName());
        form.setUser(user);
        form.setEventState(EventState.PENDING);

        if (result.hasErrors() || result.hasFieldErrors())
        {
            log.info("Form has errors");

            attr.addAttribute("user", user);
            attr.addAttribute("eventForm", form);
            attr.addAttribute("errors", result.getFieldErrors());

            if (StringUtils.isEmptyOrWhitespace(id))
            {
                attr.addAttribute("title", "Nouveau");
                attr.addAttribute("action", "Créer");
            }
            else
            {
                attr.addAttribute("title", "Modifier");
                attr.addAttribute("action", "Modifier");
            }

            return "dashboard/event-add";
        }

        if (StringUtils.isEmptyOrWhitespace(id))
        {
            eventService.save(form);
        }
        else
        {
            var event = eventService.findById(UUID.fromString(id));
            event.setName(event.getName());
            event.setDescription(form.getDescription());
            event.setStartDateTime(form.getStartDateTime());
            event.setEndDateTime(form.getEndDateTime());
            event.setScope(form.getScope());
            event.setPlace(form.getPlace());

            eventService.save(event);
        }

        return "redirect:/dashboard/events";
    }
}
