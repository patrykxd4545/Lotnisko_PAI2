package com.example.accessingdatamysql;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="customerfeedback")

public class CustomerFeedback {
    @Id
    @GeneratedValue
    private Long customerid;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookingid", referencedColumnName = "id")
    private Bookings bookings;

    @Column(nullable = false)
    private String description;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passangerid", referencedColumnName = "id")
    private Passanger passanger;



}