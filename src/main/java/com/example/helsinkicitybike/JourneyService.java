package com.example.helsinkicitybike;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JourneyService {
    private final JourneyRepository journeyRepository;

    public JourneyService(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    public Page<Journey> getJourneys(Pageable pageable) {
        return journeyRepository.findAllJourneys(pageable);
    }
}
