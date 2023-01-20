package com.example.helsinkicitybike;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Journey {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id = -1;

    private String departureTime;

    private String returnTime;

    private Integer departureStationId;

    private String departureStationName;

    private Integer returnStationId;

    private String returnStationName;

    private Integer distance;

    private Integer duration;


    public Journey() {
    }

    public Journey(String departureTime, String returnTime, Integer departureStationId, String departureStationName,
                   Integer returnStationId, String returnStationName, Integer distance, Integer duration) {
        super();
        this.departureTime = departureTime;
        this.returnTime = returnTime;
        this.departureStationId = departureStationId;
        this.departureStationName = departureStationName;
        this.returnStationId = returnStationId;
        this.returnStationName = returnStationName;
        this.distance = distance;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getDepartureStationId() {
        return departureStationId;
    }

    public void setDepartureStationId(Integer departureStationId) {
        this.departureStationId = departureStationId;
    }

    public String getDepartureStationName() {
        return departureStationName;
    }

    public void setDepartureStationName(String departureStationName) {
        this.departureStationName = departureStationName;
    }

    public Integer getReturnStationId() {
        return returnStationId;
    }

    public void setReturnStationId(Integer returnStationId) {
        this.returnStationId = returnStationId;
    }

    public String getReturnStationName() {
        return returnStationName;
    }

    public void setReturnStationName(String returnStationName) {
        this.returnStationName = returnStationName;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
