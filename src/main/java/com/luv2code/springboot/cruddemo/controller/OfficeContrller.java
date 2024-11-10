package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.DTO.OfficeDTO;
import com.luv2code.springboot.cruddemo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfficeContrller {

    private OfficeService officeService;

    @Autowired
    public OfficeContrller(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping("/offices")
    public List<OfficeDTO> findAll() {
        return officeService.findAllOfficesDTO();
    }
}
