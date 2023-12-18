package com.luschickij.criticine.criticines.controller;

import com.luschickij.criticine.criticines.dto.CinemaListRequest;
import com.luschickij.criticine.criticines.dto.CinemaResponse;
import com.luschickij.criticine.criticines.service.CinemaListService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/app")
@AllArgsConstructor
public class MainPageController {

    CinemaListService cinemaListService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(required = false) Integer page,
                        @RequestParam(required = false) String sortBy) {
        log.info("Main Page Requested");

        //checking for null
        int pageValue = page == null ? 0 : page;

        CinemaListRequest cinemaListRequest = CinemaListRequest.builder()
                .page(pageValue)
                .sortBy(sortBy)
                .build();

        List<CinemaResponse> cinemas = cinemaListService.getCinemas(cinemaListRequest);


        model.addAttribute("cinemas", cinemas);
        return "index";
    }
}

