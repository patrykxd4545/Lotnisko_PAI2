package com.airline.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlightTest {

    @Test
    void firstSearchFlight() {
        Flight flight = new Flight();
        flight.setBusinessSeats(123);
        flight.setBusinessClassCost(450);
        flight.setSource("Kielce");
        flight.setEconomySeats(122);
        Assertions.assertEquals(123, flight.getBusinessSeats());
        Assertions.assertEquals(450, flight.getBusinessClassCost());
        Assertions.assertEquals("Kielce", flight.getSource());
        Assertions.assertEquals(122, flight.getEconomySeats());
    }

}
