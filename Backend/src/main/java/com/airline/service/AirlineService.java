package com.airline.service;

import com.airline.dto.BookingDT;
import com.airline.dto.SearchFlightsDT;
import com.airline.dto.TicketDT;
import com.airline.entity.*;

import java.util.List;
import java.util.Optional;

public interface AirlineService {


    public List<Flight> searchFlights(SearchFlightsDT searchFlightsDT);
    public int addBooking(BookingDT bookingDT);
    public void updateBooking(int bookinId);
    public TicketDT fetchTicket(int bookingId);
    public double cancelTicket(int bookingId);
    public List<Booking> fetchBookings(Long userId);
    public Optional<Booking> getBooking(int bookingId);
    public List<Seat> fetchSeats(int flightId);
    public int addFeedback(CustomerFeedback customerFeedback2);

    public void updateBookings(Ebooking updatedMov, int id);
    public void deleteBookings(int id);
    public void addBookings(Ebooking mov);
    public Optional<Ebooking> getBookings(int id);
    public List<Ebooking> getAllBookings();
}
