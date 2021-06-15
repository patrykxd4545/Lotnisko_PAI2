
package com.airline.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.airline.entity.Booking;
import com.airline.entity.Flight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Integraycjny sprawdzamy czy displayAllFlight i dana wartość w bazie 1 wiersz oraz Destination zwróci odpowiedni status.
    @Test
    void shouldDisplayaddBooking() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/displayBookings"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Booking[] booking =  objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                Booking[].class);
        Assertions.assertEquals("Economy", booking[1].getTravelClass());
    }

    // Test Integraycjny sprawdzamy czy displayAllFlight i dana wartość w bazie 1 wiersz oraz Destination zwróci odpowiedni status.
    @Test
    void shouldDisplayaddBookingBlad() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/displayBookings"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Booking[] booking =  objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                Booking[].class);
        Assertions.assertEquals("Sens", booking[0].getTravelClass());
    }


    // Pobieramy oraz widzimy, że elemnty istnieja
    @Test
    void shouldReturnCorrectDisplayAllFlights() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/displayAllFlights"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
    }

    // Test Integraycjny sprawdzamy czy displayAllFlight i dana wartość w bazie 1 wiersz oraz Destination zwróci odpowiedni status.
    @Test
    void should2DisplayAllFlights() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/displayAllFlights"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Flight[] flight =  objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                Flight[].class);
        Assertions.assertEquals("NewYrk", flight[1].getDestination());
    }
}


