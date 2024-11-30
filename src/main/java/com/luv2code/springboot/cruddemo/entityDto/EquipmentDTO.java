package com.luv2code.springboot.cruddemo.entityDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDTO {
    private int cleaning;
    private int security;
    private int tables;
    private int chairs;
}
