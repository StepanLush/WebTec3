package com.poluectov.criticine.criticines.dto;

import com.poluectov.criticine.criticines.model.CinemaType;
import jakarta.persistence.Enumerated;
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
