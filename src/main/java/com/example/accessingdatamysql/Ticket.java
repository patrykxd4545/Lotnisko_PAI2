package com.example.accessingdatamysql;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long ticket_id;

    private Date flightDate;
    private Integer seat_number;
    private Double cost;



}
