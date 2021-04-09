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

}