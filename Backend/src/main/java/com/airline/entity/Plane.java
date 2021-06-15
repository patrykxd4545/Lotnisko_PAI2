package com.airline.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @Column(name = "seats_number")
    private int seatsNumber;

    @Column(name = "fuel")
    private int fuel;

    @Column(name = "weight")
    private int weight;

    @Column(name = "accident")
    private String accident;

    @Column(name = "cycles")
    private int cycles;

    @Column(name = "state")
    private boolean state;

    public Plane() {

    }

    public Plane(String mark, String model, int seatsNumber, int fuel, int weight, String accident, int cycles, boolean state) {
        this.mark = mark;
        this.model = model;
        this.seatsNumber = seatsNumber;
        this.fuel = fuel;
        this.weight = weight;
        this.accident = accident;
        this.cycles = cycles;
        this.state = state;
    }


}
