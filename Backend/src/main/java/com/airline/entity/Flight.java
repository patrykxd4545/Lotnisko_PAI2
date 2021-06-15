package com.airline.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight_detail")
public class Flight {

    @Id
    @GeneratedValue
    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "departure_from_source")
    private String departure;

    @Column(name = "arrival_at_destination")
    private String arrival;

    @Column(name = "duration")
    private String duration;

    @Column(name = "journey_date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date journeyDate;

    @Column(name = "economy_class_cost")
    private double economyClassCost;

    @Column(name = "business_class_cost")
    private double businessClassCost;

    @Column(name = "no_of_seats")
    private int noOfSeats;

    @Column(name = "economy_seat")
    private int economySeats;

    @Column(name = "business_seat")
    private int businessSeats;





    public Flight() {
    }








    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public double getEconomyClassCost() {
        return economyClassCost;
    }

    public void setEconomyClassCost(double economyClassCost) {
        this.economyClassCost = economyClassCost;
    }

    public double getBusinessClassCost() {
        return businessClassCost;
    }

    public void setBusinessClassCost(double businessClassCost) {
        this.businessClassCost = businessClassCost;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }



    @Override
    public String toString() {
        return "Flight [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", departure="
                + departure + ", arrival=" + arrival + ", duration=" + duration + ", journeyDate=" + journeyDate
                + ", economyClassCost=" + economyClassCost + ", businessClassCost=" + businessClassCost + ", noOfSeats="
                + noOfSeats + ", economySeats=" + economySeats + ", businessSeats=" + businessSeats + "]";
    }
}
