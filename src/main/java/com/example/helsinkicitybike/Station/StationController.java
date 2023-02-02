package com.example.helsinkicitybike.Station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }


    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewStation (@RequestParam Integer station_id, @RequestParam String station_name) {

        Station n = new Station();
        n.setStationId(station_id);
        n.setStationName(station_name);
        stationRepository.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    public Page<Station> getStations(@RequestParam Integer page, @RequestParam Integer size,
                                     @RequestParam String sortingField, @RequestParam String sortingDirection) {
        return stationService.fetchStations(page, size, sortingField, sortingDirection);

    }

    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getStation(@PathVariable(value =  "stationId") Integer stationId) {
        Optional<Station> station = stationService.getById(stationId);
        if (station.isPresent()) {
            return new ResponseEntity<>(station.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
