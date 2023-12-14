package com.poluectov.criticine.criticines.controller;

import com.poluectov.criticine.criticines.dto.UserLoginRequest;
import com.poluectov.criticine.criticines.error.ErrorMessage;
import com.poluectov.criticine.criticines.service.UserRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/app/login")
public class LoginController {
    UserRegisterService userRegisterService;


    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String loginPost(Model model,
                            @RequestParam("name") String name,
                            @RequestParam("password") String password)
    {
        UserLoginRequest userLoginRequest = UserLoginRequest.builder()
                .name(name)
                .password(password)
                .build();

        boolean result = userRegisterService.isUser(userLoginRequest);

        if (result) {
            //TODO: add to session
            Authentication authentication = new UsernamePasswordAuthenticationToken(name, password);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "redirect:/app/";
        }else {
            List<ErrorMessage> errors = new ArrayList<>();
            errors.add(new ErrorMessage(ErrorMessage.USER_NOT_FOUND));
            model.addAttribute("errors", errors);
            return "redirect:/app/login";
        }
    }
}
