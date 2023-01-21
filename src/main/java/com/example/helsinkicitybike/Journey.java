package com.example.helsinkicitybike;

import jakarta.persistence.*;

@Entity
@Table(name = "journeys")
public class Journey {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Integer id = -1;

    @Column(name = "departureTime")
    private String departureTime;

    @Column(name = "returnTime")
    private String returnTime;

    @Column(name = "departureStationId")
    private Integer departureStationId;

    @Column(name = "departureStationName")
    private String departureStationName;

    @Column(name = "returnStationId")
    private Integer returnStationId;

    @Column(name = "returnStationName")
    private String returnStationName;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "duration")
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
