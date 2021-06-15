
package com.airline.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // Test Integraycjny sprawdzamy czy displayAllFlight i dana wartość w bazie 1 wiersz oraz Destination zwróci odpowiedni status.
    @Test
    void shouldDisplayAllFlights() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/displayAllFlights"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Flight[] flight =  objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
                Flight[].class);
        Assertions.assertEquals("Katowice", flight[0].getDestination());
    }
// shouldreturnwhen404get

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
