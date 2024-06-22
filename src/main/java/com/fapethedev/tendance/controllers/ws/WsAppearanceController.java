package com.fapethedev.tendance.controllers.ws;

import com.fapethedev.tendance.settings.entities.Appearance;
import com.fapethedev.tendance.settings.form.AppearanceForm;
import com.fapethedev.tendance.settings.service.AppearanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
//@RequestMapping(value = "/dashboard/events")
@RequiredArgsConstructor
@Slf4j
public class WsAppearanceController implements WebMvcConfigurer
{
    private final AppearanceService appearanceService;

    @MessageMapping("/appearance")
    @SendTo("/")
    public Appearance save(AppearanceForm form)
    {
        return null;
    }

    @MessageMapping(value = "/settings/save-appearance")
    @SendTo("/settings/settings-appearance")
    public Appearance saveAppearance(@Payload AppearanceForm appearanceForm)
    {
        return appearanceService.save(appearanceForm);
    }
}
