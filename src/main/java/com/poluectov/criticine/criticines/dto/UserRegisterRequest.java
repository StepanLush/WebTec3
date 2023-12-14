package com.poluectov.criticine.criticines.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class UserRegisterRequest {
    private String name;
    private String email;
    private String password;
}
