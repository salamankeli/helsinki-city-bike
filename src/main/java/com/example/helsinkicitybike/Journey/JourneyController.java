package com.example.helsinkicitybike.Journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/journeys")
public class JourneyController {
    @Autowired
    private JourneyRepository journeyRepository;

    private final JourneyService journeyService;

    @PostMapping(path="/add")
    public @ResponseBody String addNewJourney (@RequestParam String departure_time
            , @RequestParam String return_time, @RequestParam Integer departure_station_id
            , @RequestParam String departure_station_name, @RequestParam Integer return_station_id
            , @RequestParam String return_station_name, @RequestParam Integer distance
            , @RequestParam Integer duration) {

        Journey n = new Journey();
        n.setDepartureTime(departure_time);
        n.setReturnTime(return_time);
        n.setDepartureStationId(departure_station_id);
        n.setDepartureStationName(departure_station_name);
        n.setReturnStationId(return_station_id);
        n.setReturnStationName(return_station_name);
        n.setDistance(distance);
        n.setDuration(duration);
        journeyRepository.save(n);
        return "Saved";
    }

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/journey_page")
    Page<Journey> getJourneys(Pageable pageable) {
        return journeyService.getJourneys(pageable);
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
