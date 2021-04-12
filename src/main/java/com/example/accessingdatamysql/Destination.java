package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "destination_id")
    private Long destination_id;
    private String destination_from;
    private String getDestination_to;

}
