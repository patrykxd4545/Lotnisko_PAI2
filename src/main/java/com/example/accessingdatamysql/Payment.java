package com.example.accessingdatamysql;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer payment_id;
    private Date payment_date;
    private Double amount_payment;
    private String method_payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private Ticket ticket_id;
}
