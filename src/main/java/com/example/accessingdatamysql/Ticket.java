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
    private Integer order;
    private Date flightDate;
    private Integer seat_number;
    private Double cost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passanger_id", referencedColumnName = "passanger_id")
    private Passanger passanger_id;


}
