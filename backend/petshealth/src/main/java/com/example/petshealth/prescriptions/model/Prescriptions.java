package com.example.petshealth.prescriptions.model;

import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prescriptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dosage;
    private String instructions;
    private LocalDate expirationdate;

    @OneToMany(mappedBy = "prescriptions")
    @JsonBackReference
    private List<VisitPrescription> visitPrescriptions;
}
