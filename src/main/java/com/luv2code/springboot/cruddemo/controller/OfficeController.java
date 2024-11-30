package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Office;
import com.luv2code.springboot.cruddemo.entityDto.OfficeDTO;
import com.luv2code.springboot.cruddemo.service.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class OfficeController {

    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/officesDTO")
    public List<OfficeDTO> findAll() {
        return officeService.findAllOfficesDTO();
    }


}
