package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="bookings")

public class Bookings {
    @Id
    @GeneratedValue
    private Long id;
    private String bookingDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passanger_id", referencedColumnName = "passanger_id")
    private Passanger passanger_id;


}