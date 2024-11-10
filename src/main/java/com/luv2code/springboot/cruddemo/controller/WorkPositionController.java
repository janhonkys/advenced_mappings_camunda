package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import com.luv2code.springboot.cruddemo.service.WorkPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
public class WorkPositionController {

    private WorkPositionService workPositionService;

    @Autowired
    public WorkPositionController(WorkPositionService workPositionService) {
        this.workPositionService = workPositionService;
    }

    @GetMapping("/workpositionDTO/{employeeId}")
    public HashSet<WorkPositionDTO> getWorkPositionDTOByEmployeeId(@PathVariable int employeeId) {
        return workPositionService.getWorkPositionsByEmployeeId(employeeId);
    }

    @GetMapping("/workposition")
    public List<WorkPosition> getWorkPositionsByEmployeeId() {
        return workPositionService.findAll();
    }

    @GetMapping("/workposition/{employeeId}")
    public Optional<WorkPosition> getWorkPositionsByEmployeeId(@PathVariable int employeeId) {
        return workPositionService.findById(employeeId);
    }
}
