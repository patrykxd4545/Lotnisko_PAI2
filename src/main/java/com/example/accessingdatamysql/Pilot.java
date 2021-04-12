package com.example.accessingdatamysql;
import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="pilots")
public class Pilot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer  pilot_id;
    private Integer passport_number;
    private Integer airlines_id;
    private Integer experience;
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private Crew crew_id;
}
