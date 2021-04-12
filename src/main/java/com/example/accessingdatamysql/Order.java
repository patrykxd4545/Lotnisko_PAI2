package com.example.accessingdatamysql;


import javax.persistence.*;

@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue
    private Long order_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Food_Service service_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passanger_id", referencedColumnName = "passanger_id")
    private Passanger passanger_id;


}