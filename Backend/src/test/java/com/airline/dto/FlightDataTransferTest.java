package com.airline.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlightDataTransferTest {

    //Jednostkowy sprawdzanie FlightDataTransfer POMYSLNY
    @Test
    void firstFlightDataTransfer() {
        FlightDataTransfer flightDataTransfer = new FlightDataTransfer();
        flightDataTransfer.setArrivalTime("11");
        flightDataTransfer.setAdminId(123);
        flightDataTransfer.setBusinessClassCost(12345);
        flightDataTransfer.setDestination("Kielce");
        flightDataTransfer.setSource("Warszawa");
        Assertions.assertEquals("11", flightDataTransfer.getArrivalTime());
        Assertions.assertEquals(123, flightDataTransfer.getAdminId());
        Assertions.assertEquals(12345, flightDataTransfer.getBusinessClassCost());
        Assertions.assertEquals("Kielce", flightDataTransfer.getDestination());
        Assertions.assertEquals("Warszawa", flightDataTransfer.getSource());

    }

    //Jednostkowy sprawdzanie FlightDataTransfer BLEDNY
    @Test
    void SecondFlightDataTransfer() {
        FlightDataTransfer flightDataTransfer = new FlightDataTransfer();
        flightDataTransfer.setArrivalTime("1133");
        flightDataTransfer.setAdminId(123);
        flightDataTransfer.setBusinessClassCost(12345);
        flightDataTransfer.setDestination("Warszawa");
        flightDataTransfer.setSource("Kielce");
        Assertions.assertEquals("11", flightDataTransfer.getArrivalTime());
        Assertions.assertEquals(123, flightDataTransfer.getAdminId());
        Assertions.assertEquals(12345, flightDataTransfer.getBusinessClassCost());
        Assertions.assertEquals("Kielce", flightDataTransfer.getDestination());
        Assertions.assertEquals("Warszawa", flightDataTransfer.getSource());

    }

}
