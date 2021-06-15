package com.airline.service;


import com.airline.dao.AirlineOperationDao;
import com.airline.dao.GenericDao;
import com.airline.dto.BookingDT;
import com.airline.dto.SearchFlightsDT;
import com.airline.dto.TicketDT;
import com.airline.entity.*;
import com.airline.model.User;
import com.airline.repo.BookingRepository;
import com.airline.repo.EbookingRepository;
import com.airline.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineOperationDao airlineDao;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    GenericDao dao;

    @Autowired
    MailSender mailSender;


    @Override
    public int addFeedback(CustomerFeedback customerFeedback2) {
        CustomerFeedback updatedFeedback = (CustomerFeedback) dao.save(customerFeedback2);

        return updatedFeedback.getFeedbackId();
    }

    @Override
    public List<Flight> searchFlights(SearchFlightsDT searchFlightsDT) {
        return airlineDao.searchFlightOperation(searchFlightsDT);
    }

    @Override
    @Transactional
    public int addBooking(BookingDT bookingDT) {

        User user = new User();
        Flight flight = new Flight();
        Booking booking = new Booking();
        Passenger passenger = new Passenger();


        booking.setNoOfPassengers(bookingDT.getNoOfPassenger());
        booking.setCost(bookingDT.getCost());
        booking.setTicketMailingId(bookingDT.getEmail());
        booking.setBookingDate(LocalDate.now());
        booking.setTravelClass(bookingDT.getTravelClass());


        user = dao.fetchById(User.class, bookingDT.getUserId());

        flight = dao.fetchById(Flight.class, bookingDT.getFlightId());

        System.out.println(flight);
        System.out.println(user);

        booking.setUser(user);
        booking.setFlight(flight);
        booking.setJourneyDate(flight.getJourneyDate());

        booking.setSource(flight.getSource());
        booking.setDestination(flight.getDestination());
        booking.setDeparture(flight.getDeparture());
        booking.setArrival(flight.getArrival());

        System.out.println(booking);
        Booking fetchedBooking = (Booking) dao.save(booking);
        int fetchedBookingId = fetchedBooking.getBookingId();
        System.out.println(fetchedBooking);

        int i = 0;
        HashSet<Passenger> passengers = new HashSet<Passenger>();
        for (Passenger p : bookingDT.getPassengerList()) {
            p.setBooking(fetchedBooking);
            p.setBookingStatus("Not Booked");
            p.setSeatId(bookingDT.getSeats().get(i));
            System.out.println(p.getSeatId());
            i++;
            airlineDao.addPassenger(p);
        }

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("airlinepsk@gmail.com");
        message.setTo(user.getEmail());
        message.setSubject("[Booking number: "+ fetchedBooking.getBookingId() + "] Succesfully booked!");
        message.setText("Hello: " + user.getDisplayName() + " your booking with the number: " + fetchedBooking.getBookingId() + " with cost: " + booking.getCost() + "USD has been successfully booked");
        mailSender.send(message);

        return fetchedBookingId;
    }

    @Override
    public void updateBooking(int bookinId) {
        List<Passenger> passengerList = airlineDao.fetchPassenger(bookinId);
        for (Passenger p : passengerList) {
            p.setBookingStatus("Confirmed");
            Seat seat = dao.fetchById(Seat.class, p.getSeatId());
            seat.setIsBooked("true");
            dao.save(seat);
            dao.save(p);
        }
        Booking booking = dao.fetchById(Booking.class, bookinId);
        int confirmedSeats = booking.getNoOfPassengers();

        Flight flight = airlineDao.fetchFlight(booking);

        if (booking.getTravelClass().equalsIgnoreCase("economy")) {
            flight.setEconomySeats(flight.getEconomySeats() - confirmedSeats);
        } else {
            flight.setBusinessSeats(flight.getBusinessSeats() - confirmedSeats);
        }
        flight = (Flight) dao.save(flight);

        Payment payment = new Payment();
        payment.setAmountPaid(booking.getCost());
        payment.setPaymentMode("Net Banking / UPI");
        payment.setBooking(booking);
        payment = (Payment) dao.save(payment);
    }


    @Override
    public TicketDT fetchTicket(int bookingId) {
        TicketDT ticket = airlineDao.fetchTicket(bookingId);
        return ticket;
    }

    @Override
    public double cancelTicket(int bookingId) {
        double refund = airlineDao.cancelTicket(bookingId);
        return refund;
    }

    @Override
    public List<Booking> fetchBookings(Long id) {
        return airlineDao.fetchBooking(id); //(userId)
    }

    @Override
    public List<Seat> fetchSeats(int flightId) {
        return airlineDao.fetchSeats(flightId);

    }

    @Autowired
    EbookingRepository ebookingRepository;

    @Override
    public List<Ebooking> getAllBookings() {

        ArrayList<Ebooking> allBookings = new ArrayList<>();
        ebookingRepository.findAll().forEach(allBookings::add);
        return allBookings;
    }

    public Optional<Ebooking> getBookings(int id) {
        return ebookingRepository.findById(id);

    }

    public void addBookings(Ebooking mov) {
        ebookingRepository.save(mov);

    }


    public void deleteBookings(int id) {

        ebookingRepository.deleteById(id);
    }

    public void updateBookings(Ebooking updatedMov, int id) {
        ebookingRepository.save(updatedMov);


    }

    @Autowired
    BookingRepository bookingRepository;

    public Optional<Booking> getBooking(int bookingid) {
        return bookingRepository.findById(bookingid);

    }
}
