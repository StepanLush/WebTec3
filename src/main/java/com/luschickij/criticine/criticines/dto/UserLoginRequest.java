package com.luschickij.criticine.criticines.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Data
@AllArgsConstructor
@Builder
public class UserLoginRequest {
    String name;
    String password;
}
