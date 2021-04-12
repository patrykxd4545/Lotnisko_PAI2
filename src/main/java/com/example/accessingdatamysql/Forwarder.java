package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="forwarder")

public class Forwarder {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String passportnumber;

    @Column(nullable = false)
    private Integer emergencynumber;

    @Column(nullable = false)
    private String salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person person;



}