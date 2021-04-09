package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="passanger")

public class Passanger {
    @Id
    @GeneratedValue
    private Long passanger_id;

    @Column(nullable = false)
    private Long phonenumber;

    @Column(nullable = false)
    private Long passportnumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private Ticket ticket_id;

}