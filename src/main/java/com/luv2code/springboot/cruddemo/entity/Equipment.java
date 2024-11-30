package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
