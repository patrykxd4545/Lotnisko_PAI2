package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="baggage")
public class Baggage {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long bookingid;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passanger_id", referencedColumnName = "passanger_id")
    private Passanger passanger_id;


}
