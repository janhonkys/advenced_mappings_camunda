package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Office;
import com.luv2code.springboot.cruddemo.entityDto.OfficeDTO;
import com.luv2code.springboot.cruddemo.dao.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeService {

    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<OfficeDTO> findAllOfficesDTO() {
        return officeRepository.findAllOfficesDTO();
    }

    public List<Office> findAllOffices() {
        return officeRepository.findAll();
    }

}
