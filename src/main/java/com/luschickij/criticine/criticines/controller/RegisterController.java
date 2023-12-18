package com.luschickij.criticine.criticines.controller;

import com.luschickij.criticine.criticines.dto.UserRegisterRequest;
import com.luschickij.criticine.criticines.error.ErrorMessage;
import com.luschickij.criticine.criticines.error.UserAlreadyExistsException;
import com.luschickij.criticine.criticines.service.UserRegisterService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
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
@RequestMapping("/app/register")
public class RegisterController {

    UserRegisterService userRegisterService;
    @GetMapping
    public String getRegister(){
        return "register";
    }
    @PostMapping
    public String postRegister(Model model,
                               @RequestParam("username") String username,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password){

        UserRegisterRequest userRegisterRequest = UserRegisterRequest.builder()
                .name(username)
                .email(email)
                .password(password)
                .build();

        List<ErrorMessage> errors = new ArrayList<>();
        try{
            userRegisterService.register(userRegisterRequest);
        }catch (UserAlreadyExistsException | EntityExistsException e){
            errors.add(new ErrorMessage(ErrorMessage.USER_EXISTS));
        }catch (Exception e){
            errors.add(new ErrorMessage(ErrorMessage.DB_ERROR));
        }
        if (errors.isEmpty()){
            return "redirect:/app/login";
        }else{
            model.addAttribute("errors", errors);
            return "register";
        }
    }
}
