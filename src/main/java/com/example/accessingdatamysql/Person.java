package com.example.accessingdatamysql;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee_id;
}
