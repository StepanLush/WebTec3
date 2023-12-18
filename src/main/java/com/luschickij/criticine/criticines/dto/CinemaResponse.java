package com.luschickij.criticine.criticines.dto;

import com.luschickij.criticine.criticines.model.CinemaType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CinemaResponse {

    Float rating;

    int creationYear;
    String pictureFile;

    CinemaType type;

}
