package com.example.helsinkicitybike.Journey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/bike")
public class JourneyController {
    @Autowired
    private JourneyRepository journeyRepository;

    private final JourneyService journeyService;

    @PostMapping(path="/add") // Map ONLY POST Requests
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
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

    @GetMapping("/journeys")
    Page<Journey> getJourneys(Pageable pageable) {
        return journeyService.getJourneys(pageable);
    }
}