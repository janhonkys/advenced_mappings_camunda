package com.luv2code.springboot.cruddemo.DTO;

public class OfficeDTO {

    private int id;
    private String street;
    private String city;
    private String manager;

    public OfficeDTO(int id, String street, String city, String manager) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.manager = manager;
    }

    public OfficeDTO() {
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "OfficeDTO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
