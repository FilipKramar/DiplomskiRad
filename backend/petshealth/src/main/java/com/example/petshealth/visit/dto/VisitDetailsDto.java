package com.example.petshealth.visit.dto;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.veterinarian.model.Veterinarian;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDetailsDto {

    private Visit visit;

    private List<Prescriptions> prescriptions;

    private List<Therapies> therapies;


}
