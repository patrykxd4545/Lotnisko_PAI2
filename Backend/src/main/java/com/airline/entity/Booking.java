package com.airline.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.airline.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="booking_detail")
public class Booking {

    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String emailId;

    @Column(name = "contact_number")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_from_source")
    private String departure;

    @Column(name = "arrival_at_destination")
    private String arrival;

    @Column(name = "journey_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date journeyDate;

    @Column(name = "no_of_passengers")
    private int noOfPassengers;

    @Column(name = "cost")
    private double cost;

    @Column(name = "ticket_mailing_id")
    private String ticketMailingId;

    @Column(name="booking_date")
    private LocalDate bookingDate;

    @Column(name="travel_class")
    private String travelClass;

    @OneToOne
    @JoinColumn(name = "user_id_fk")
    @JsonIgnore
    private User user;

    @OneToOne
    @JoinColumn(name = "flight_id_fk")
    @JsonIgnore
    private Flight flight;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private Set<Passenger> passengerList;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private Payment payment;

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination
                + ", departure=" + departure + ", arrival=" + arrival + ", journeyDate=" + journeyDate
                + ", noOfPassengers=" + noOfPassengers + ", cost=" + cost + ", ticketMailingId=" + ticketMailingId
                + ", bookingDate=" + bookingDate + ", travelClass=" + travelClass + ", user=" + user + ", flight="
                + flight + ", passengerList=" + passengerList + ", payment=" + payment + "]";
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getTicketMailingId() {
        return ticketMailingId;
    }

    public void setTicketMailingId(String ticketMailingId) {
        this.ticketMailingId = ticketMailingId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Set<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(Set<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
