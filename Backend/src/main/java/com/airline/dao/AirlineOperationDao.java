package com.airline.dao;

import com.airline.dto.SearchFlightsDT;
import com.airline.dto.TicketDT;
import com.airline.entity.Booking;
import com.airline.entity.Flight;
import com.airline.entity.Passenger;
import com.airline.entity.Seat;

import java.util.List;

public interface AirlineOperationDao {

    public List<Flight> searchFlightOperation(SearchFlightsDT searchFlightsDT);
    public void addPassenger(Passenger passenger);
    public List<Passenger> fetchPassenger(int bookingId);
    public Flight fetchFlight(Booking booking);
    public TicketDT fetchTicket(int bookingId);
    public double cancelTicket(int bookingId);
    public List<Booking> fetchBooking(Long id);
    public List<Seat> fetchSeats(int flightId);

    void addPassenger();
}
