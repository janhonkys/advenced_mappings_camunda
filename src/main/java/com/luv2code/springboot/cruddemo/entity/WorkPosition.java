package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "work_position")
public class WorkPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "employee_id")  // Foreign key to Employee table
    @JsonIgnore
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "office_id")  // Foreign key to Office table
    private Office office;

    public WorkPosition() {}

    public WorkPosition(String name, Office office, Employee employee) {
        this.name = name;
        this.office = office;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "WorkPosition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", office=" + office +
                ", employee=" + employee +
                '}';
    }
}
