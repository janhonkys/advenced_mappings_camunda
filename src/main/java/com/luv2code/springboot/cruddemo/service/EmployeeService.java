package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DTO.EmployeeInfoDTO;
import com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.dao.WorkPositionRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private WorkPositionRepository workPositionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, WorkPositionRepository workPositionRepository) {
        this.employeeRepository = employeeRepository;
        this.workPositionRepository = workPositionRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not found employee id - "+theId);
        }
        return theEmployee;
    }

    public List<EmployeeInfoDTO> findEmployeesCustomInfo() {
        List<EmployeeInfoDTO> employeeInfoDTOs = employeeRepository.findEmployeesCustomInfo();
        for (int i = 0; i < employeeInfoDTOs.size(); i++) {
            employeeInfoDTOs.get(i).setWorkPositions(workPositionRepository.findWorkPositionsByEmployeeId(i+1));
        }
        return employeeInfoDTOs;
    }

    public EmployeeInfoDTO findEmployeeCustomInfo(int id) {
        Optional<EmployeeInfoDTO> employeeInfoOpt = employeeRepository.findEmployeeContactInfoById(id);
        HashSet<WorkPositionDTO> workPositionList = workPositionRepository.findWorkPositionsByEmployeeId(id);

        EmployeeInfoDTO employeeInfo = employeeInfoOpt.orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employeeInfo.setWorkPositions(workPositionList);

        return employeeInfo;
    }
}
