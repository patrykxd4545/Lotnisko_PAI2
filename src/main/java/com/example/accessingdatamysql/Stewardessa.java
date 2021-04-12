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
    private Food_Service Service_ID;
    private Integer passport_number;
    private Integer experience;
    private Double salary;
    private Integer crew_id;

    public Integer getStewardessa_ID() {
        return Stewardessa_ID;
    }

    public void setStewardessa_ID(Integer stewardessa_ID) {
        Stewardessa_ID = stewardessa_ID;
    }

    public Food_Service getService_ID() {
        return Service_ID;
    }

    public void setService_ID(Food_Service service_ID) {
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

    public Integer getCrew_id() {
        return crew_id;
    }

    public void setCrew_id(Integer crew_id) {
        this.crew_id = crew_id;
    }
}
