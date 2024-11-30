package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Contact;
import com.luv2code.springboot.cruddemo.entity.Office;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import com.luv2code.springboot.cruddemo.entityDto.EmployeeInfoDTO;
import com.luv2code.springboot.cruddemo.entityDto.EquipmentDTO;
import com.luv2code.springboot.cruddemo.entityDto.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.dao.WorkPositionRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
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
            log.warn("Did not found employee id - "+theId);
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
        Optional<EmployeeInfoDTO> employeeInfoOpt = employeeRepository.findEmployeesCustomInfoById(id);
        HashSet<WorkPositionDTO> workPositionList = workPositionRepository.findWorkPositionsByEmployeeId(id);

        EmployeeInfoDTO employeeInfo = employeeInfoOpt.orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employeeInfo.setWorkPositions(workPositionList);

        return employeeInfo;
    }

    public EquipmentDTO findEquipmentByEmployeeId(int id) {
        Optional<EquipmentDTO> equipmentInfo = employeeRepository.findEquipmentByEmployeeId(id);
        return equipmentInfo.orElseThrow(() -> new NoSuchElementException("Equipment not found"));
    }

    public List<Employee> findEmployeesByOfficeCity(String city) {
        return employeeRepository.findEmployeesByOfficeCity(city);
    }

    public List<EmployeeInfoDTO> findEmployeesByOfficeManagerDto(String manager) {
        return findEmployees(employeeRepository.findEmployeesByOfficeManager(manager));
    }

    public List<EmployeeInfoDTO> findEmployeesByOfficeCityDto(String city) {
        return findEmployees(employeeRepository.findEmployeesByOfficeCity(city));
    }

    public List<EmployeeInfoDTO> findEmployees(List<Employee> employeeList) {
        ArrayList<EmployeeInfoDTO> list = new ArrayList<>();
        for (Employee tmp : employeeList) {
            EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO(
                    tmp.getFirstName(),
                    tmp.getLastName(),
                    getStreet(tmp),
                    getCity(tmp),
                    getCleaning(tmp),
                    getEmail(tmp),
                    getPhone(tmp)
            );
            list.add(employeeInfoDTO);
        }
        return list;
    }

    private String getPhone(Employee tmp) {
        if (tmp == null || tmp.getContacts() == null) {
            return null; // Return null if the employee or work positions list is null
        }
        for (Contact contact : tmp.getContacts()) {
            if (contact.getContactType().equals("Phone")) {
                return contact.getContactValue();
            }
        }
        return null;
    }

    private String getEmail(Employee tmp) {
        if (tmp == null || tmp.getContacts() == null) {
            return null; // Return null if the employee or work positions list is null
        }
        for (Contact contact : tmp.getContacts()) {
            if (contact.getContactType().equals("Email")) {
                return contact.getContactValue();
            }
        }
        return null;
    }

    private int getCleaning(Employee tmp) {
        if (tmp == null || tmp.getWorkpositions() == null) {
            return -1; // Return null if the employee or work positions list is null
        }
        for (WorkPosition workPosition : tmp.getWorkpositions()) {
            if (workPosition != null && workPosition.getOffice() != null && workPosition.getOffice().getEquipment() != null) {
                return workPosition.getOffice().getEquipment().getCleaning(); // Return the street of the first valid office
            }
        }
        return -1; // Return null if no valid office is found
    }

    private String getCity(Employee tmp) {
        if (tmp == null || tmp.getWorkpositions() == null) {
            return null; // Return null if the employee or work positions list is null
        }
        for (WorkPosition workPosition : tmp.getWorkpositions()) {
            if (workPosition != null && workPosition.getOffice() != null) {
                return workPosition.getOffice().getCity(); // Return the street of the first valid office
            }
        }
        return null; // Return null if no valid office is found
    }

    private String getStreet(Employee tmp) {
        if (tmp == null || tmp.getWorkpositions() == null) {
            return null; // Return null if the employee or work positions list is null
        }
        for (WorkPosition workPosition : tmp.getWorkpositions()) {
            if (workPosition != null && workPosition.getOffice() != null) {
                return workPosition.getOffice().getStreet(); // Return the street of the first valid office
            }
        }
        return null; // Return null if no valid office is found
    }

}
