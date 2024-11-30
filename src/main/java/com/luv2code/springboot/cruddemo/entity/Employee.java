package com.luv2code.springboot.cruddemo.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employee2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
