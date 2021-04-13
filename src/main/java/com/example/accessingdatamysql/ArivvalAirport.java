package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="arivvalairport")

public class ArivvalAirport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forwarderid", referencedColumnName = "id")
    private Forwarder forwarder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "depatureairportid", referencedColumnName = "id")
    private DepatureAirport depatureairport;

}
