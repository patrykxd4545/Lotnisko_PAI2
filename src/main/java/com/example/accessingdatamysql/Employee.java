package com.example.accessingdatamysql;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer employee_id;
    private String first_name;
    private String last_name;
    private Date birthday;
    private String email;
}
