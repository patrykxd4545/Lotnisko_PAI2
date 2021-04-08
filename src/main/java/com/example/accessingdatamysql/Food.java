package com.example.accessingdatamysql;

import org.apache.tomcat.jni.Address;

import javax.persistence.*;

@Entity
@Table(name = "foods")
public class Food {
<<<<<<< HEAD
=======

>>>>>>> origin/main
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id")
    private Long id;
<<<<<<< HEAD
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
=======

>>>>>>> origin/main
}
