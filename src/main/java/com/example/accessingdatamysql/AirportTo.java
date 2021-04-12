package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="airportto")

public class AirportTo {
    @Id
    @GeneratedValue
    private Long  id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forwarderid", referencedColumnName = "id")
    private Forwarder forwarder;



}
