package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "manager")
    private String manager;

    @OneToOne(mappedBy = "office", cascade = CascadeType.ALL)
    @JsonIgnore
    private WorkPosition workPosition;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public Office() {}

    public Office(String street, String city, String manager, Equipment equipment) {
        this.street = street;
        this.manager = manager;
        this.equipment = equipment;
        this.city = city;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public WorkPosition getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(WorkPosition workPosition) {
        this.workPosition = workPosition;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", manager='" + manager + '\'' +
                ", workPosition=" + workPosition +
                ", equipment=" + equipment +
                '}';
    }
}
