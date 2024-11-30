package com.luv2code.springboot.cruddemo.entityDto;

import java.util.Objects;

public class WorkPositionDTO {
    private int id;
    private String name;

    public WorkPositionDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkPositionDTO that = (WorkPositionDTO) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "WorkPositionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


