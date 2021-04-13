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
    private Food_service service_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private Ticket ticket_id;


}