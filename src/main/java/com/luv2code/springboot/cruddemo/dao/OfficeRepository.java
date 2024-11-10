package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.DTO.OfficeDTO;
import com.luv2code.springboot.cruddemo.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Integer> {

    @Query("SELECT new com.luv2code.springboot.cruddemo.DTO.OfficeDTO(o.id, o.street, o.city, o.manager) FROM Office o")
    List<OfficeDTO> findAllOfficesDTO();
}




