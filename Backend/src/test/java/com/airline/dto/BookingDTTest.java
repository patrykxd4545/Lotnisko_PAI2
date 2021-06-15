package com.airline.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

class BookingDTTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    //JEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWEJEDNOSTKOWE
    @Test
    void bookingDtt() throws Exception {
        int noOfPassenger = 3;
        BookingDT bookingDT = new BookingDT();
        bookingDT.getCost();
        bookingDT.setCost(45);
    }

    @Test
    void getAllBookings() {
 BookingDT bookingDT = new BookingDT();
 bookingDT.setCost(100);
        Assertions.assertEquals(100, bookingDT.getCost());
    }

    @Test
    void oneNeighboor() {
        BookingDT bookingDT = new BookingDT();
        bookingDT.setTravelClass("Economy");
        Assertions.assertEquals("Economy", bookingDT.getTravelClass());
        bookingDT.nextCycle();
        Assertions.assertEquals("Economy", bookingDT.getTravelClass());

    }
}
