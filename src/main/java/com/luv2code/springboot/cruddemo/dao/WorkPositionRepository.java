package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface WorkPositionRepository extends JpaRepository<WorkPosition, Integer> {

    @Query("SELECT new com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO(wp.id, wp.name) " +
            "FROM WorkPosition wp " +
            "WHERE wp.employee.id = :employeeId")
    HashSet<WorkPositionDTO> findWorkPositionsByEmployeeId(int employeeId);
}
