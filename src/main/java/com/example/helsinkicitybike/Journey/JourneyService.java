package com.example.helsinkicitybike.Journey;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JourneyService {
    private final JourneyRepository journeyRepository;

    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public Page<Journey> fetchJourneys(Integer page, Integer pageSize, String sortingField, String sortingDirection) {
        Sort sort = Sort.by(Sort.Direction.valueOf(sortingDirection), sortingField);
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return journeyRepository.findAll(pageable);
    }
    public Optional<Journey> getDepartureStationCount(Integer departureStationId) {
        return journeyRepository.countByDepartureStationId(departureStationId);
    }

    public Optional<Journey> getReturnStationCount(Integer returnStationId) {
        return journeyRepository.countByReturnStationId(returnStationId);
    }
}
