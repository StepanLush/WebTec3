package com.luschickij.criticine.criticines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/m/create")
public class CreateMovieController {

    @GetMapping
    public String createMovie() {
        return "m/createMovie";
    }
}

