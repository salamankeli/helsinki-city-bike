package com.example.helsinkicitybike.Journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/journeys")
public class JourneyController {
    @Autowired
    private JourneyRepository journeyRepository;

    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/all")
    public Page<Journey> getJourneys(@RequestParam Integer page, @RequestParam Integer size,
                                     @RequestParam String sortingField, @RequestParam String sortingDirection) {
        return journeyService.fetchJourneys(page, size, sortingField, sortingDirection);
    }

    @GetMapping("/departures/{departureStationId}")
    public Optional<Journey> getDepartureStationCount(@PathVariable(value =  "departureStationId") Integer departureStationId) {
        return journeyService.getDepartureStationCount(departureStationId);
    }

    @GetMapping("/returns/{returnStationId}")
    public Optional<Journey> getReturnStationCount(@PathVariable(value =  "returnStationId") Integer returnStationId) {
        return journeyService.getReturnStationCount(returnStationId);
    }
}
