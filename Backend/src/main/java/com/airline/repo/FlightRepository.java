package com.airline.repo;

import com.airline.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer>, CrudRepository<Flight, Integer> {
    List<Flight> findByFlightId(int flightId);
}
