package com.luschickij.criticine.criticines.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 150)
    private String name;
    @Column(unique = true)
    private String email;
    private String passwordHash;

    @Enumerated(EnumType.ORDINAL)
    private UserRole role;
    private int status;

}
