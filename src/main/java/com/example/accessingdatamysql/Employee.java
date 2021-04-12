package com.example.accessingdatamysql;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String first_name;
    private String last_name;
    private Date birthday;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person person;


}
