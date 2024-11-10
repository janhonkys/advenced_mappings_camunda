package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DTO.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.dao.WorkPositionRepository;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class WorkPositionService {

    private WorkPositionRepository workPositionRepository;

    @Autowired
    public WorkPositionService(WorkPositionRepository workPositionRepository) {
        this.workPositionRepository = workPositionRepository;
    }

    public HashSet<WorkPositionDTO> getWorkPositionsByEmployeeId(int employeeId) {
        return workPositionRepository.findWorkPositionsByEmployeeId(employeeId);
    }

    public List<WorkPosition> findAll() {
        return workPositionRepository.findAll();
    }

    public Optional<WorkPosition> findById(int id) {
        return workPositionRepository.findById(id);
    }

}
