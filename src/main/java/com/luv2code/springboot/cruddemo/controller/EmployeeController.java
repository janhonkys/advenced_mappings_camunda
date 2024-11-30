package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entityDto.EmployeeInfoDTO;
import com.luv2code.springboot.cruddemo.entityDto.EquipmentDTO;
import com.luv2code.springboot.cruddemo.entityDto.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping("/employees-city/{city}")
    public List<Employee> findEmployeesByOfficeCity(@PathVariable String city) {
        return employeeService.findEmployeesByOfficeCity(city);
    }

    @GetMapping("/employees-cityDto/{city}")
    public List<EmployeeInfoDTO> findEmployeesByOfficeCityDto(@PathVariable String city) {
        return employeeService.findEmployeesByOfficeCityDto(city);
    }

    @GetMapping("/employees-managerDto/{manager}")
    public List<EmployeeInfoDTO> findEmployeesByOfficeManagerDto(@PathVariable String manager) {
        return employeeService.findEmployeesByOfficeManagerDto(manager);
    }

    @GetMapping("/employeeInfo")
    public List<EmployeeInfoDTO> findEmployeesCustomInfo() {
        return employeeService.findEmployeesCustomInfo();
    }

    @GetMapping("/employeeInfo/{id}")
    public EmployeeInfoDTO findEmployeesCustomInfoById(@PathVariable int id) {
        return employeeService.findEmployeeCustomInfo(id);
    }

    @GetMapping("/employeeEquipment/{id}")
    public EquipmentDTO findEquipmentByEmployeeId(@PathVariable int id) {
        return employeeService.findEquipmentByEmployeeId(id);
    }



}
