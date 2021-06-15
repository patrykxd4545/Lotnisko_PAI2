package com.airline.controller;

import com.airline.dto.FlightDataTransfer;
import com.airline.entity.CustomerFeedback;
import com.airline.entity.Flight;
import com.airline.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addFlight")
    public String addFlight(@RequestBody FlightDataTransfer flightDT) {
        System.out.println("Airline controller");
        Flight flight = new Flight();

        flight.setSource(flightDT.getSource());
        flight.setDestination(flightDT.getDestination());
        flight.setJourneyDate(flightDT.getJourneyDate());
        flight.setDeparture(flightDT.getDepartureTime());
        flight.setArrival(flightDT.getArrivalTime());
        flight.setEconomyClassCost(flightDT.getEconomyClassCost());
        flight.setBusinessClassCost(flightDT.getBusinessClassCost());
        flight.setNoOfSeats(flightDT.getNoOfSeats());
        flight.setEconomySeats(flightDT.getEconomySeats());
        flight.setBusinessSeats(flightDT.getBusinessSeats());
        System.out.println("Airline controller");
        adminService.addFlight(flight);

        return null;
    }

    @DeleteMapping("/deleteFlight")
    public String deleteFlight(@RequestParam("id") int FlightId) {
        adminService.deleteFight(FlightId);
        return null;
    }
    ///
    @DeleteMapping("api/deleteUser")
    public String deleteFlight(@RequestParam("id") long userId) {
    adminService.deleteUser(userId);
    return null;
    }




    @GetMapping("/displayAllFlights")
    public List<Flight> displayAllFlights() {
        List<Flight> flightList = adminService.displayAllFlights();
        return flightList;
    }

    @GetMapping("/displayFlight")
    public Flight displayFlight(@RequestParam("id") int flightId) {
        System.out.println(flightId);
        Flight flight = adminService.displayFlight(flightId);
        System.out.println(flight);
        return flight;
    }

    @GetMapping("/displayFeedbacks")
    public List<CustomerFeedback> displayAllFeedbacks() {
        List<CustomerFeedback> feedbackList = adminService.displayAllFeedbacks();
        return feedbackList;
    }

    @DeleteMapping("/deleteFeedback")
    public String deleteFeedback(@RequestParam("id") int feedbackId) {
        adminService.deleteFeedback(feedbackId);
        return null;
    }

    @GetMapping("/displayFeedback")
    public CustomerFeedback displayFeedback(@RequestParam("id") int feedbackId) {
        System.out.println(feedbackId);
        CustomerFeedback customerFeedback = adminService.displayFeedback(feedbackId);
        System.out.println(customerFeedback);
        return customerFeedback;
    }


}
