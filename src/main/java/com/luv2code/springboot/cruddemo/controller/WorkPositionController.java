package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entityDto.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import com.luv2code.springboot.cruddemo.service.WorkPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@Slf4j
public class WorkPositionController {

    private WorkPositionService workPositionService;

    @Autowired
    public WorkPositionController(WorkPositionService workPositionService) {
        this.workPositionService = workPositionService;
    }

    @GetMapping("/workpositionsDTO-epmloyeeId/{employeeId}")
    public HashSet<WorkPositionDTO> getWorkPositionsDtoByEmployeeId(@PathVariable int employeeId) {
        return workPositionService.getWorkPositionsByEmployeeId(employeeId);
    }

    @GetMapping("/workpositionsDTO-officeId/{officeId}")
    public List<WorkPositionDTO> getWorkPositionsDtoByOfficeId(@PathVariable int officeId) {
        return workPositionService.getWorkPositionsByOfficeId(officeId);
    }

    @GetMapping("/workpositions")
    public List<WorkPosition> getWorkPositions() {
        return workPositionService.findAll();
    }

    @GetMapping("/workpositionsDTO")
    public List<WorkPositionDTO> getWorkPositionsDTO() {
        return workPositionService.findAllDTO();
    }

    @GetMapping("/workpositionsDTO/{id}")
    public WorkPositionDTO getWorkPositionDTO(@PathVariable int id) {
        return workPositionService.findDTObyId(id);
    }

    @GetMapping("/workpositions/{employeeId}")
    public HashSet<WorkPositionDTO> getWorkPositionsByEmployeeId(@PathVariable int employeeId) {
        return workPositionService.getWorkPositionsByEmployeeId(employeeId);
    }
}
