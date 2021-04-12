package com.example.accessingdatamysql;

import javax.persistence.*;

@Entity
@Table(name = "stewardessas")
public class Stewardessa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stewardessa")
    private Integer Stewardessa_ID;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Food_service Service_ID;
    private Integer passport_number;
    private Integer experience;
    private Double salary;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crew_id", referencedColumnName = "crew_id")
    private Crew crew_id;

    public Integer getStewardessa_ID() {
        return Stewardessa_ID;
    }

    public void setStewardessa_ID(Integer stewardessa_ID) {
        Stewardessa_ID = stewardessa_ID;
    }

    public Food_service getService_ID() {
        return Service_ID;
    }

    public void setService_ID(Food_service service_ID) {
        Service_ID = service_ID;
    }

    public Integer getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(Integer passport_number) {
        this.passport_number = passport_number;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }



}