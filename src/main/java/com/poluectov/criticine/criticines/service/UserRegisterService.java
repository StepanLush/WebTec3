package com.poluectov.criticine.criticines.service;

import com.poluectov.criticine.criticines.data.UserRepository;
import com.poluectov.criticine.criticines.dto.UserLoginRequest;
import com.poluectov.criticine.criticines.dto.UserRegisterRequest;
import com.poluectov.criticine.criticines.error.UserAlreadyExistsException;
import com.poluectov.criticine.criticines.model.User;
import com.poluectov.criticine.criticines.model.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegisterService {

    UserRepository userRepository;
    PasswordService passwordService;
    public void register(UserRegisterRequest userRegisterRequest) throws Exception {

        User existingUser = userRepository.findByName(userRegisterRequest.getName());
        if (existingUser != null){
            throw new UserAlreadyExistsException();
        }

        String passwordHash = passwordService.createPassword(userRegisterRequest);

        User newUser = User.builder()
                .name(userRegisterRequest.getName())
                .email(userRegisterRequest.getEmail())
                .passwordHash(passwordHash)
                .role(UserRole.USER)
                .status(0)
                .build();

        userRepository.save(newUser);
    }

    public boolean isUser(UserLoginRequest userLoginRequest) {
        User existingUser = userRepository.findByName(userLoginRequest.getName());

        if (existingUser == null){
            return false;
        }
        return passwordService.verifyPassword(userLoginRequest, existingUser.getPasswordHash());
    }

}
