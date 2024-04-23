package com.fapethedev.tendance.main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * App error controller
 * @author Fapethedev
 * @since 1.0
 */
@Controller
@RequestMapping
public class HandlingErrorController implements ErrorController
{
    /**
     * Show the approriate error page following the http error status code.
     * <br/>
     * Get error from path=/error
     * @param request server request
     * @return error page resource
     */
    @GetMapping(path = "/error")
    public String showErrorPage(HttpServletRequest request)
    {
        var status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null && Integer.parseInt(status.toString()) == HttpStatus.NOT_FOUND.value())
        {
            return "errors/error-404";
        }
        else if (status != null && Integer.parseInt(status.toString()) == HttpStatus.UNAUTHORIZED.value())
        {
            return "errors/error-403";
        }

        return "errors/error";
    }
}
