package com.luv2code.springboot.cruddemo.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="available")
    private boolean available;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<WorkPosition> workpositions = new ArrayList<>(); // Changed to List

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>(); // Changed to List

    public Employee() {}

    // Getters and setters for fields
    public Employee(int id, String firstName, String lastName, int age, boolean available) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<WorkPosition> getWorkpositions() {
        return workpositions;
    }

    public void setWorkpositions(ArrayList<WorkPosition> workpositions) {
        this.workpositions = workpositions;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", available=" + available +
                ", workpositions=" + workpositions +
                ", contacts=" + contacts +
                '}';
    }
}
