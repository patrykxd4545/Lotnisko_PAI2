package com.airline.service;

import com.airline.entity.CustomerFeedback;
import com.airline.entity.Flight;
import com.airline.model.User;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    public int addFlight(Flight flight);
    public Flight displayFlight(int flightId);
    public void deleteFight(int flightId);
    public void updateFlight(Flight updatedFlight, int flightId);
    public Optional<Flight> findFlightById(int flightId);

    public void deleteUser(long userId);
    public void updateUser(User updatedUser, long userId);

    public List<Flight> displayAllFlights();
    public List<CustomerFeedback> displayAllFeedbacks();
    public CustomerFeedback displayFeedback(int feedbackId);
    public void deleteFeedback(int feedbackId);

    public void sendMessage(CustomerFeedback responseFeedback, int feedbackId);
    public Optional<CustomerFeedback> getCustomerFeedback(int feedbackId);
}
