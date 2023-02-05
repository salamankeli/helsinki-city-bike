package com.example.helsinkicitybike;

import com.example.helsinkicitybike.Journey.Journey;
import com.example.helsinkicitybike.Journey.JourneyRepository;
import com.example.helsinkicitybike.Station.Station;
import com.example.helsinkicitybike.Station.StationRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBOperationRunner implements CommandLineRunner {
    @Autowired
    JourneyRepository jRepo;

    @Autowired
    StationRepository sRepo;

    String[] csvFiles = {"test1.csv", "test2.csv", "test3.csv"};

    @Override
    public void run(String... args) throws Exception {
        if (jRepo.count() > 0) {
            System.out.println("Csv files are only saved into an empty database.");
            return;
        }
        List<Station> stationList = new ArrayList<>();

        List<Journey> journeyList = new ArrayList<>();

        for (String csvFile : csvFiles) {
            FileReader filereader = new FileReader(csvFile);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                var departure = nextRecord[0];
                var return_time = nextRecord[1];
                var departure_station_id = nextRecord[2];
                var departure_station_name = nextRecord[3];
                var return_station_id = nextRecord[4];
                var return_station_name = nextRecord[5];
                var distance = nextRecord[6];
                var duration = nextRecord[7];
                try {
                    if (Integer.parseInt(distance) > 10 && Integer.parseInt(duration) > 10) {
                        var journey = new Journey(LocalDateTime.parse(departure), LocalDateTime.parse(return_time), Integer.parseInt(departure_station_id),
                                departure_station_name, Integer.parseInt(return_station_id), return_station_name,
                                Integer.parseInt(distance), Integer.parseInt(duration));
                        journeyList.add(journey);
                        var departure_station = new Station(Integer.parseInt(departure_station_id), departure_station_name);
                        var return_station = new Station(Integer.parseInt(return_station_id), return_station_name);
                        stationList.add(departure_station);
                        stationList.add(return_station);

                    }
                } catch (Exception e) {
                }
            }
        }
        System.out.println("Starting to save data");
        jRepo.saveAll(journeyList);
        sRepo.saveAll(stationList);
        System.out.println("Saved csv data");
    }

}
