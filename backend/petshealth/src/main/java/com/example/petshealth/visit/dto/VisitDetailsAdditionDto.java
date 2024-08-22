package com.example.petshealth.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class VisitDetailsAdditionDto {

    List<Long> prescriptionId;
    List<Long>therapyId;
}
