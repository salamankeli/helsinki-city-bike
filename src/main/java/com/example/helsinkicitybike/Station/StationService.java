package com.example.helsinkicitybike.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Page<Station> getStations(Pageable pageable) {
        return stationRepository.findAllStations(pageable);
    }
}
