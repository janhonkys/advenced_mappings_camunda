package com.luv2code.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "work_position")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
