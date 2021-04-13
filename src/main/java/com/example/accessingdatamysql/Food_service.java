package com.example.accessingdatamysql;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Entity
@Table(name = "food_services")
public class Food_service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Long Service_ID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    private Food Food_ID;

    public Long getService_ID() {
        return Service_ID;
    }

    public void setService_ID(Long service_ID) {
        Service_ID = service_ID;
    }

    public Food getFood_ID() {
        return Food_ID;
    }

    public void setFood_ID(Food food_ID) {
        Food_ID = food_ID;
    }
}
