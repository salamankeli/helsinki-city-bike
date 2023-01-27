package com.example.helsinkicitybike;

import jakarta.persistence.*;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    private Integer stationId = -1;

    @Column(name = "stationName")
    private String stationName;

    public Station() {
    }

    public Station(Integer stationId, String stationName) {
        super();
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
