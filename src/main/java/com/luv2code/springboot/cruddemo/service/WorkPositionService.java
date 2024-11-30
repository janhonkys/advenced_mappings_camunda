package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.entityDto.WorkPositionDTO;
import com.luv2code.springboot.cruddemo.dao.WorkPositionRepository;
import com.luv2code.springboot.cruddemo.entity.WorkPosition;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WorkPositionService {

    private WorkPositionRepository workPositionRepository;

    @Autowired
    public WorkPositionService(WorkPositionRepository workPositionRepository) {
        this.workPositionRepository = workPositionRepository;
    }

    public HashSet<WorkPositionDTO> getWorkPositionsByEmployeeId(int employeeId) {
        return workPositionRepository.findWorkPositionsByEmployeeId(employeeId);
    }

     public List<WorkPositionDTO> getWorkPositionsByOfficeId(int officeId) {
        return workPositionRepository.findWorkPositionsByOfficeId(officeId);
    }

    public List<WorkPosition> findAll() {
        return workPositionRepository.findAll();
    }

    public List<WorkPositionDTO> findAllDTO() {
        return workPositionRepository.findAll().stream()
                .map(tmp -> new WorkPositionDTO(tmp.getId(), tmp.getName()))
                .collect(Collectors.toList());
    }

    public WorkPositionDTO findDTObyId(int id) {
        WorkPosition workPosition = workPositionRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Did not find WorkPosition with ID - " + id);
                    throw new EntityNotFoundException("WorkPosition with ID " + id + " not found");
                });

        return new WorkPositionDTO(workPosition.getId(), workPosition.getName());
    }
}
