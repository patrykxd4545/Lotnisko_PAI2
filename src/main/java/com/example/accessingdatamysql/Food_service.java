package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
@Table(name = "food_services")
public class Food_service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Long service_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    private Food food_id;
}
