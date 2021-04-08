package com.example.accessingdatamysql;
import javax.persistence.*;

@Entity
@Table(name="crews")
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer crew_id;
    private String name;
    private String last_name;
    private Integer pesel;
    private String role;
    private Integer employee_id;

}
