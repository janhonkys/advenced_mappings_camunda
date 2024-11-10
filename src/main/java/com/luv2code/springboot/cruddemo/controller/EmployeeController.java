package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.DTO.EmployeeInfoDTO;
import com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import com.luv2code.springboot.cruddemo.service.WorkPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@RestController
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

    @GetMapping("/employeeInfo")
    public List<EmployeeInfoDTO> findEmployeesCustomInfo() {
        return employeeService.findEmployeesCustomInfo();
    }

    @GetMapping("/employeeInfo/{id}")
    public EmployeeInfoDTO findEmployeesCustomInfoById(@PathVariable int id) {
        return employeeService.findEmployeeCustomInfo(id);
    }

    @GetMapping("/employees-check")
    public void employeesCheck(){
        EmployeeInfoDTO employee = employeeService.findEmployeeCustomInfo(4);

        EmployeeInfoDTO employee1 = new EmployeeInfoDTO("Emily", "Davis", "123 Elm St", "Praha", 10, "karel.doe@example.com", null);
        HashSet<WorkPositionDTO> workPositions = new HashSet<>();
        WorkPositionDTO workPosition = new WorkPositionDTO(4, "Boss");
        WorkPositionDTO workPosition1 = new WorkPositionDTO(5, "CEO");
        workPositions.add(workPosition);
        workPositions.add(workPosition1);
        employee1.setWorkPositions(workPositions);

        System.out.println(employee);
        System.out.println(employee1);
        System.out.println(employee.equals(employee1));
    }

}
