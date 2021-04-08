package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="bookings")

public class Bookings {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passangerid", referencedColumnName = "id")
    private Passanger passanger;


}