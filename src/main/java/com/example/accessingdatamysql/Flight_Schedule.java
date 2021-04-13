package com.example.accessingdatamysql;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "flight_schedules")
public class Flight_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_schedule_id")
    private Long Flight_Schedule_ID;


    private Date date;
    private Time time;
    private Integer plane_id;
    private  Integer pilot_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_id", referencedColumnName = "destination_id")
    private Destination destination_id;
}
