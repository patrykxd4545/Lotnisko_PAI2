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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private Crew crew_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id", referencedColumnName = "plane_id")
    private Plane plane_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id", referencedColumnName = "destination_id")
    private Destination destination_id;


}
