package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="baggage")
public class Baggage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long bookingid;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private Ticket ticket_id;


}
