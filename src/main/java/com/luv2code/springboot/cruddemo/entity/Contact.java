package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "contact_type")
    private String contactType;

    @Column(name = "contact_value")
    private String contactValue;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonIgnore
    private Employee employee;

    public Contact() {
    }

    public Contact(String contactType, String contactValue) {
        this.contactType = contactType;
        this.contactValue = contactValue;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactValue() {
        return contactValue;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", contactType='" + contactType + '\'' +
                ", contactValue='" + contactValue + '\'' +
                ", employee=" + employee +
                '}';
    }
}
