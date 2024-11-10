package com.luv2code.springboot.cruddemo.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class EmployeeInfoDTO {

    private String firstName;
    private String lastName;
    private HashSet<WorkPositionDTO> workPositions = new HashSet<>(); // List of work positions
    private String street;
    private String city;
    private int cleaning;
    private String email;
    private String phone;

    // Constructor should match the result of the query
    public EmployeeInfoDTO(String firstName, String lastName,
                           String street, String city, int cleaning, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.cleaning = cleaning;
        this.email = email;
        this.phone = phone;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public HashSet<WorkPositionDTO> getWorkPositions() {
        return workPositions;
    }

    public void setWorkPositions(HashSet<WorkPositionDTO> workPositions) {
        this.workPositions = workPositions;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getCleaning() { return cleaning; }
    public void setCleaning(int cleaning) { this.cleaning = cleaning; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInfoDTO that = (EmployeeInfoDTO) o;
        return cleaning == that.cleaning && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(workPositions, that.workPositions) && Objects.equals(street, that.street) && Objects.equals(city, that.city) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, workPositions, street, city, cleaning, email, phone);
    }

    @Override
    public String toString() {
        return "EmployeeInfoDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workPositions=" + workPositions +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", cleaning=" + cleaning +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
