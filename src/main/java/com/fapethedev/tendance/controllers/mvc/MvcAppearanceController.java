package com.fapethedev.tendance.controllers.mvc;

import com.fapethedev.tendance.settings.form.AppearanceForm;
import com.fapethedev.tendance.settings.service.IAppearanceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping(value = "/dashboard/settings")
@RequiredArgsConstructor
@Slf4j
public class MvcAppearanceController implements WebMvcConfigurer
{
    private final IAppearanceService<UUID> appearanceService;

    /**
     *
     * @param form
     * @param result
     * @param id
     * @param attr
     * @return
     */
    @RequestMapping(
            value = {"/dashboard/settings/save-appearance"},
            method = RequestMethod.POST
    )
    public String saveAppearance(@Valid @ModelAttribute("appearance") AppearanceForm form,
                           final BindingResult result,
                           @PathVariable(required = false) final String id,
                           final RedirectAttributes attr)
    {
        appearanceService.save(form);

        return "redirect:/dashboard/settings";
    }
}
