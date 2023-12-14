package com.poluectov.criticine.criticines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/m/movie")
public class MovieController {


    @GetMapping
    public String movie() {
        return "m/movie";
    }
}
