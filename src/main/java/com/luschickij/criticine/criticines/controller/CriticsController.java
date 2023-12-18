package com.luschickij.criticine.criticines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/critics")
public class CriticsController {

    @GetMapping
    public String getCritics() {
        return "critics";
    }
}
