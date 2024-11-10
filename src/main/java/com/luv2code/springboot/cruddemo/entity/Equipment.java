package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cleaning")
    private int cleaning;

    @Column(name = "security")
    private int security;

    @Column(name = "tables")
    private int tables;

    @Column(name = "chairs")
    private int chairs;

    @OneToOne(mappedBy = "equipment")
    @JsonIgnore
    private Office office;

    // Constructors
    public Equipment() {}

    public Equipment(int cleaning, int security, int tables, int chairs, Office office) {
        this.cleaning = cleaning;
        this.security = security;
        this.tables = tables;
        this.chairs = chairs;
        this.office = office;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCleaning() {
        return cleaning;
    }

    public void setCleaning(int cleaning) {
        this.cleaning = cleaning;
    }

    public int getSecurity() {
        return security;
    }

    public void setSecurity(int security) {
        this.security = security;
    }

    public int getTables() {
        return tables;
    }

    public void setTables(int tables) {
        this.tables = tables;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "cleaning=" + cleaning +
                ", security=" + security +
                ", tables=" + tables +
                ", chairs=" + chairs +
                ", office=" + office +
                '}';
    }
}
