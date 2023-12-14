package com.poluectov.criticine.criticines.service;


import com.poluectov.criticine.criticines.data.CinemaRepository;
import com.poluectov.criticine.criticines.dto.CinemaListRequest;
import com.poluectov.criticine.criticines.dto.CinemaResponse;
import com.poluectov.criticine.criticines.model.Cinema;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CinemaListService {


    CinemaRepository cinemaRepository;
    public List<CinemaResponse> getCinemas(CinemaListRequest request) {

        return cinemaRepository.findByOrder(request.getSortBy(), request.getPage()).stream()
                .map(this::mapToCinemaResponse)
                .toList();
    }

    private CinemaResponse mapToCinemaResponse(Cinema cinema) {
        return CinemaResponse.builder()
                .type(cinema.getType())
                .rating(cinema.getRating())
                .creationYear(cinema.getCreationYear())
                .pictureFile(cinema.getPictureFile())
                .build();
    }
}
