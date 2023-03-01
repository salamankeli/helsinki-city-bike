package com.example.helsinkicitybike;

import com.example.helsinkicitybike.Journey.Journey;
import com.example.helsinkicitybike.Journey.JourneyRepository;
import com.example.helsinkicitybike.Station.Station;
import com.example.helsinkicitybike.Station.StationRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DBOperationRunner implements CommandLineRunner {
    // TODO: Optional/conditional data import run
    @Autowired
    JourneyRepository jRepo;

    @Autowired
    StationRepository sRepo;

    @Value("${csv-files}") // TODO: Only use single csv file for import?
    String[] csvFiles;

    // TODO: Add test cases for data import. With failing row, with already data skipping load etc
    @Override
    public void run(String... args) throws Exception {
        if (jRepo.count() > 0) {
            System.out.println("Csv files are only saved into an empty database.");
            return;
        }
        List<Station> stationList = new ArrayList<>();
        List<Journey> journeyList = new ArrayList<>();

        for (String csvFile : csvFiles) {
            FileReader fileReader = new FileReader(csvFile);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                var departure = nextRecord[0];
                var returnTime = nextRecord[1];
                var departureStationId = nextRecord[2];
                var departureStationName = nextRecord[3];
                var returnStationId = nextRecord[4];
                var returnStationName = nextRecord[5];
                var distance = nextRecord[6];
                var duration = nextRecord[7];
                try {
                    if (Integer.parseInt(distance) > 10 && Integer.parseInt(duration) > 10) {
                        var journey = new Journey(LocalDateTime.parse(departure), LocalDateTime.parse(returnTime), Integer.parseInt(departureStationId),
                                departureStationName, Integer.parseInt(returnStationId), returnStationName,
                                Integer.parseInt(distance), Integer.parseInt(duration));
                        journeyList.add(journey);
                        var departureStation = new Station(Integer.parseInt(departureStationId), departureStationName);
                        var returnStation = new Station(Integer.parseInt(returnStationId), returnStationName);
                        stationList.add(departureStation);
                        stationList.add(returnStation);

                    }
                } catch (Exception e) {
                    //Invalid journey // TODO: Log / handle exception?
                }
            }
        }
        System.out.println("Starting to save data");
        jRepo.saveAll(journeyList);
        sRepo.saveAll(stationList);
        System.out.println("Saved csv data");
    }

}
