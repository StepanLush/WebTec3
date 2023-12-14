package com.poluectov.criticine.criticines.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCinemaReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    @JoinColumn(name = "fk_cinema_id", referencedColumnName = "cinema_id")
    Cinema cinema;

    int rating;
    String review;
}
