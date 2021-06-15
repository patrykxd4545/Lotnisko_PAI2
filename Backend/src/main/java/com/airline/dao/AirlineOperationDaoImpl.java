package com.airline.dao;

import com.itextpdf.text.pdf.PdfWriter;
import com.airline.dto.SearchFlightsDT;
import com.airline.dto.TicketDT;
import com.airline.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AirlineOperationDaoImpl implements AirlineOperationDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    protected JavaMailSender mailSender;

    @Autowired
    protected GenericDao dao;

    @Autowired
    MailSender emailSender;
    @Override
    public List<Flight> searchFlightOperation(SearchFlightsDT searchFlightsDT) {

        if (searchFlightsDT.getTravelClass().equalsIgnoreCase("economy")) {
            String fetchedQuery = "select f from Flight f where f.source=:qsource and f.destination=:qdestination and f.journeyDate=:qdate and f.economySeats >= :qtravellers";
            Query query = entityManager.createQuery(fetchedQuery);
            query.setParameter("qsource", searchFlightsDT.getSource());
            query.setParameter("qdestination", searchFlightsDT.getDestination());
            query.setParameter("qdate", searchFlightsDT.getTravelDate());
            query.setParameter("qtravellers", searchFlightsDT.getNoOfPassengers());
            return query.getResultList();

        } else {
            String fetchedQuery = "select f from Flight f where f.source=:qsource and f.destination=:qdestination and f.journeyDate=:qdate and f.businessSeats >= :qtravellers";
            Query query = entityManager.createQuery(fetchedQuery);
            query.setParameter("qsource", searchFlightsDT.getSource());
            query.setParameter("qdestination", searchFlightsDT.getDestination());
            query.setParameter("qdate", searchFlightsDT.getTravelDate());
            query.setParameter("qtravellers", searchFlightsDT.getNoOfPassengers());
            return query.getResultList();
        }

    }

    @Override
    public void addPassenger(Passenger passenger) {
        Passenger updatedPassenger = (Passenger) dao.save(passenger);
    }

    @Override
    public List<Passenger> fetchPassenger(int bookingId) {

        String fetchedQuery = "select p from Passenger p where p.booking.bookingId=:qbookingId";
        Query query = entityManager.createQuery(fetchedQuery);
        query.setParameter("qbookingId", bookingId);
        List<Passenger> passengers = query.getResultList();
        return passengers;
    }

    @Override
    public Flight fetchFlight(Booking booking) {

        Flight bookedFlight = booking.getFlight();
        int bookedFlightId = bookedFlight.getFlightId();
        String fetchedQuery = "select f from Flight f where f.flightId=:qflightId";
        Query query = entityManager.createQuery(fetchedQuery);
        query.setParameter("qflightId", bookedFlightId);
        Flight fetchedFlight = (Flight) query.getSingleResult();
        return fetchedFlight;
    }

    @Override
    public TicketDT fetchTicket(int bookingId) {

        TicketDT ticketDT = new TicketDT();
        try {

            Booking booking = new Booking();
            booking = dao.fetchById(Booking.class, bookingId);
            Flight bookedFlight = booking.getFlight();
            int bookedFlightId = bookedFlight.getFlightId();
            String fetchedQuery1 = "select f from Flight f where f.flightId=:qflightId";
            Query query1 = entityManager.createQuery(fetchedQuery1);
            query1.setParameter("qflightId", bookedFlightId);
            Flight fetchedFlight = (Flight) query1.getSingleResult();


            String fetchedQuery2 = "select p from Passenger p where p.booking.bookingId=:qbookingId";
            Query query2 = entityManager.createQuery(fetchedQuery2);
            query2.setParameter("qbookingId", bookingId);
            List<Passenger> passengerList = query2.getResultList();



            ticketDT.setBookingId(bookingId);
            ticketDT.setFlightId(fetchedFlight.getFlightId());
            ticketDT.setSource(fetchedFlight.getSource());
            ticketDT.setDestination(fetchedFlight.getDestination());
            ticketDT.setJourneyDate(booking.getJourneyDate());
            ticketDT.setArrivalTime(fetchedFlight.getArrival());
            ticketDT.setDepartureTime(fetchedFlight.getDeparture());
            ticketDT.setTravelClass(booking.getTravelClass());
            ticketDT.setCost(booking.getCost());

            List<Passenger> passengerData = new ArrayList<Passenger>();
            for (Passenger p : passengerList) {
                passengerData.add(p);
            }
            ticketDT.setPassengerList(passengerData);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketDT;

    }

    @Override
    public double cancelTicket(int bookingId) {


        Booking booking = new Booking();
        booking = dao.fetchById(Booking.class, bookingId);
        Flight bookedFlight = booking.getFlight();
        int bookedFlightId = bookedFlight.getFlightId();
        String fetchedQuery1 = "select f from Flight f where f.flightId=:qflightId";
        Query query1 = entityManager.createQuery(fetchedQuery1);
        query1.setParameter("qflightId", bookedFlightId);
        Flight fetchedFlight = (Flight) query1.getSingleResult();


        String fetchedQuery2 = "select p from Passenger p where p.booking.bookingId=:qbookingId";
        Query query2 = entityManager.createQuery(fetchedQuery2);
        query2.setParameter("qbookingId", bookingId);
        List<Passenger> passengerList = query2.getResultList();

        for (Passenger p : passengerList) {
            p.setBookingStatus("Cancelled");
            Seat seat = dao.fetchById(Seat.class, p.getSeatId());
            seat.setIsBooked("false");
            dao.save(seat);
        }
        for (Passenger p : passengerList) {
            dao.save(p);
        }

        CancelBooking cancelBooking = new CancelBooking();
        cancelBooking.setArrival(booking.getArrival());
        cancelBooking.setBookingDate(booking.getBookingDate());
        cancelBooking.setBookingId(booking.getBookingId());
        cancelBooking.setSource(booking.getSource());
        cancelBooking.setDestination(booking.getDestination());
        cancelBooking.setDeparture(booking.getDeparture());
       // cancelBooking.setUserId(booking.getuser()); //.getUserId()
        cancelBooking.setFlightId(fetchedFlight.getFlightId());
        cancelBooking.setCancellingDate(LocalDate.now());
        cancelBooking.setTravelClass(booking.getTravelClass());
       // cancelBooking.setTicketMailingId(booking.getTicketMailingId());
        cancelBooking.setJourneyDate(booking.getJourneyDate());
        cancelBooking.setNoOfPassengers(booking.getNoOfPassengers());
        cancelBooking.setCost(booking.getCost());

        double cost = booking.getCost();
        double refund = cost - (cost * 0.25);
        cancelBooking.setRefund(refund);
        int noOfPassengers = booking.getNoOfPassengers();

        if (booking.getTravelClass().equalsIgnoreCase("economy")) {
            fetchedFlight.setEconomySeats(fetchedFlight.getEconomySeats() + noOfPassengers);
        } else {
            fetchedFlight.setBusinessSeats(fetchedFlight.getBusinessSeats() + noOfPassengers);
        }
        Flight flight = (Flight) dao.save(fetchedFlight);
        dao.delete(booking);

        CancelBooking cB = (CancelBooking) dao.save(cancelBooking);


        return refund;
    }

    @Override
    public List<Booking> fetchBooking(Long userId) {

        String fetchedQuery = "select b from Booking b where b.user.id=:quserId";
        Query query = entityManager.createQuery(fetchedQuery);
        query.setParameter("quserId", userId);
        return query.getResultList();
    }

    @Override
    public List<Seat> fetchSeats(int flightId) {
        String fetchedQuery = "select s from Seat s where s.flightId=:qflightId";
        Query query = entityManager.createQuery(fetchedQuery);
        query.setParameter("qflightId", flightId);
        return query.getResultList();
    }

    @Override
    public void addPassenger() {

    }

}
