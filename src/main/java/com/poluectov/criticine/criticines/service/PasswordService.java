package com.poluectov.criticine.criticines.service;

import com.poluectov.criticine.criticines.dto.UserLoginRequest;
import com.poluectov.criticine.criticines.dto.UserRegisterRequest;
import com.poluectov.criticine.criticines.security.PasswordVerifier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasswordService {

    PasswordVerifier passwordVerifier;
    public String createPassword(UserRegisterRequest userRegisterRequest){
        return passwordVerifier.createPasswordHash(userRegisterRequest.getPassword() + userRegisterRequest.getName());
    }

    public boolean verifyPassword(UserLoginRequest userRegisterRequest, String hashedPassword){
        return passwordVerifier.verifyPassword(userRegisterRequest.getPassword() + userRegisterRequest.getName(), hashedPassword);
    }
}
