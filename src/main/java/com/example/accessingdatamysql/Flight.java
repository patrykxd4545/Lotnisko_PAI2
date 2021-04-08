package com.example.accessingdatamysql;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer flight_id;
    private Time arrival_time;
    private Time departure_time;
    private String source;
    private String destination;
    private Integer plane_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id", referencedColumnName = "pilot_id")
    private Pilot pilot_id;
}
