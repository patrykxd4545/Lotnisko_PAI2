package com.example.accessingdatamysql;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "planes")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plane_id")
    private Long plane_id;

    private Long weight;
    private String brand;
    private String model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flight flight_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private Crew crew_id;

}
