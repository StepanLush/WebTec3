package com.poluectov.criticine.criticines.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="cinema")
public class Cinema {
    @Id
    @Column(name="cinema_id", columnDefinition = "decimal(38,0)")
    BigInteger id;

    @Column(name="cinema_name")
    String name;
    @Column(name="cinema_rating")
    Float rating;
    @Column(name="cinema_creation_year")
    int creationYear;
    @Column(name="cinema_picture")
    String pictureFile;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="fk_cinema_type", columnDefinition = "tinyint")
    CinemaType type;

}
