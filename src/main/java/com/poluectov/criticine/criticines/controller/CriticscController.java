package com.poluectov.criticine.criticines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/critics")
public class CriticscController {

    @GetMapping
    public String getCritics() {
        return "critics";
    }
}
