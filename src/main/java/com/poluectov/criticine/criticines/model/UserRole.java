package com.poluectov.criticine.criticines.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

public enum UserRole {
    USER, ADMIN;
}
