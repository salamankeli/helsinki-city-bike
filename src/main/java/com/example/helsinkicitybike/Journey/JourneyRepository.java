package com.example.helsinkicitybike.Journey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Integer> {
    @Query("select count(departureStationId) from Journey where departureStationId=?1")
    Optional<Journey> countByDepartureStationId(Integer departureStationId);

    @Query("select count(returnStationId) from Journey where returnStationId=?1")
    Optional<Journey> countByReturnStationId(Integer returnStationId);
}
