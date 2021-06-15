package com.airline.service;


import com.airline.dao.GenericDao;
import com.airline.entity.CustomerFeedback;
import com.airline.entity.Flight;
import com.airline.entity.Seat;
import com.airline.function.MiscFunction;
import com.airline.model.User;
import com.airline.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    GenericDao dao;

    @Autowired
    MiscFunction miscFunction;

    @Override
    public int addFlight(Flight flight) {
        flight.setDuration(miscFunction.calcDuration(flight.getDeparture(), flight.getArrival()));
        //flight.setDuration("2 Hrs");
        //System.out.println("asi");
        int ecoSeats = flight.getEconomySeats();
        int busSeats = flight.getBusinessSeats();

        Flight updatedFlight = (Flight) dao.save(flight);


        for(int i = 0; i<ecoSeats; i++) {
            Seat seat = new Seat();
            seat.setTravelClass("Economy");
            seat.setFlightId(updatedFlight.getFlightId());
            seat.setIsBooked("false");
            dao.save(seat);
        }
        for(int i = 0; i<busSeats; i++) {
            Seat seat = new Seat();
            seat.setTravelClass("Business");
            seat.setFlightId(updatedFlight.getFlightId());
            seat.setIsBooked("false");
            dao.save(seat);
        }
        //System.out.println(updatedFlight);
        return updatedFlight.getFlightId();
    }

    @Override
    public Flight displayFlight(int flightId) {
        Flight flight = dao.fetchById(Flight.class, flightId);
        return flight;
    }

    @Override
    public void deleteFight(int flightId) {
        Flight flight = dao.fetchById(Flight.class, flightId);
        dao.delete(flight);
    }
    ///
    @Override
    public void deleteUser(long userId) {
        User user = dao.fetchById(User.class, userId);
        dao.delete(user);
    }

    @Autowired
    UserRepository userRepository;

    public void updateUser(User updatedUser, long userId) {
        userRepository.save(updatedUser);
    }


    @Override
    public List<Flight> displayAllFlights() {
        List<Flight> flightList = dao.fetchAll(Flight.class);
        return flightList;
    }

    @Override
    public Optional<Flight> findFlightById(int flightId) {
        return flightRepository.findById(flightId);
    }

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void updateFlight(Flight updatedFlight, int flightId) {
        flightRepository.save(updatedFlight);
    }

    @Override
    public List<CustomerFeedback> displayAllFeedbacks() {
        List<CustomerFeedback> feedbackList = dao.fetchAll(CustomerFeedback.class);
        return feedbackList;
    }

    @Override
    public CustomerFeedback displayFeedback(int feedbackId) {
        CustomerFeedback customerFeedback = dao.fetchById(CustomerFeedback.class, feedbackId);
        return customerFeedback;
    }

    @Override
    public void deleteFeedback(int feedbackId) {
        CustomerFeedback customerFeedback = dao.fetchById(CustomerFeedback.class, feedbackId);
        dao.delete(customerFeedback);
    }

    @Autowired
    MailSender emailSender;

    @Autowired
    protected JavaMailSender mailSender;

    @Override
    public void sendMessage(CustomerFeedback responseFeedback, int feedbackId) {
        CustomerFeedback customerFeedback = dao.fetchById(CustomerFeedback.class, feedbackId);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("airlinepsk@gmail.com");
        message.setTo(customerFeedback.getEmailFeedback());
        message.setSubject("Answer from AirlinePSK support");
        message.setText(customerFeedback.getResponseMessage());
        mailSender.send(message);

        customerFeedbackRepository.save(responseFeedback);
    }

    @Autowired
    CustomerFeedbackRepository customerFeedbackRepository;

    @Override
    public Optional<CustomerFeedback> getCustomerFeedback(int feedbackId) {
        return customerFeedbackRepository.findById(feedbackId);
    }

}
