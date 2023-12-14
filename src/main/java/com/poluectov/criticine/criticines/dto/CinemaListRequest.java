package com.poluectov.criticine.criticines.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CinemaListRequest {

    String sortBy;
    int page;

}
