package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entityDto.EmployeeInfoDTO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entityDto.EquipmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT new com.luv2code.springboot.cruddemo.entityDto.EmployeeInfoDTO(e.firstName, e.lastName, o.street, o.city, eq.cleaning, " +
            "MAX(CASE WHEN c.contactType = 'email' THEN c.contactValue ELSE null END) AS email, " +
            "MAX(CASE WHEN c.contactType = 'phone' THEN c.contactValue ELSE null END) AS phone) " +
            "FROM Employee e " +
            "JOIN e.workpositions wp " +
            "JOIN wp.office o " +
            "JOIN o.equipment eq " +
            "LEFT JOIN e.contacts c " +
            "GROUP BY e.id, e.firstName, e.lastName, o.street, o.city, eq.cleaning")
    List<EmployeeInfoDTO> findEmployeesCustomInfo();

    @Query("SELECT new com.luv2code.springboot.cruddemo.entityDto.EmployeeInfoDTO(e.firstName, e.lastName, o.street, o.city, eq.cleaning, " +
            "MAX(CASE WHEN c.contactType = 'email' THEN c.contactValue ELSE null END) AS email, " +
            "MAX(CASE WHEN c.contactType = 'phone' THEN c.contactValue ELSE null END) AS phone) " +
            "FROM Employee e " +
            "JOIN e.workpositions wp " +
            "JOIN wp.office o " +
            "JOIN o.equipment eq " +
            "LEFT JOIN e.contacts c " +
            "WHERE e.id = :id " +
            "GROUP BY e.id, e.firstName, e.lastName, o.street, o.city, eq.cleaning")
    Optional<EmployeeInfoDTO> findEmployeesCustomInfoById(@Param("id") int id);

    @Query("SELECT new com.luv2code.springboot.cruddemo.entityDto.EquipmentDTO(eq.cleaning, eq.security, eq.tables, eq.chairs)" +
            "FROM Employee e " +
            "JOIN e.workpositions wp " +
            "JOIN wp.office o " +
            "JOIN o.equipment eq " +
            "WHERE e.id = :id " +
            "GROUP BY eq.cleaning, eq.security, eq.tables, eq.chairs")
    Optional<EquipmentDTO> findEquipmentByEmployeeId(@Param("id") int id);

    @Query("SELECT e FROM Employee e JOIN e.workpositions wp JOIN wp.office o WHERE o.city = :city")
    List<Employee> findEmployeesByOfficeCity(@Param("city") String city);

    @Query("SELECT e FROM Employee e JOIN e.workpositions wp JOIN wp.office o WHERE o.manager = :manager")
    List<Employee> findEmployeesByOfficeManager(@Param("manager") String manager);

}