package com.airline.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchFlightsDTTest {

    //Jednostkowy sprawdzanie FlightDataTransfer POMYSLNY
    @Test
    void firstSearchFlight() {
        SearchFlightsDT searchFlightsDT = new SearchFlightsDT();
        searchFlightsDT.setDestination("Warszawa");
        searchFlightsDT.setNoOfPassengers(231);
        searchFlightsDT.setSource("Kielce");
        searchFlightsDT.setTravelClass("Economy");
        Assertions.assertEquals("Warszawa", searchFlightsDT.getDestination());
        Assertions.assertEquals(231, searchFlightsDT.getNoOfPassengers());
        Assertions.assertEquals("Kielce", searchFlightsDT.getSource());
        Assertions.assertEquals("Economy", searchFlightsDT.getTravelClass());
    }

    //Jednostkowy sprawdzanie FlightDataTransfer BLEDNY
    @Test
    void secondSearchFlight() {
        SearchFlightsDT searchFlightsDT = new SearchFlightsDT();
        searchFlightsDT.setDestination("Warszawa");
        searchFlightsDT.setNoOfPassengers(231);
        searchFlightsDT.setSource("Kielce");
        searchFlightsDT.setTravelClass("Economy");
        Assertions.assertEquals("Kielce", searchFlightsDT.getDestination());
        Assertions.assertEquals(231, searchFlightsDT.getNoOfPassengers());
        Assertions.assertEquals("Kielce", searchFlightsDT.getSource());
        Assertions.assertEquals("Economy", searchFlightsDT.getTravelClass());
    }
}
