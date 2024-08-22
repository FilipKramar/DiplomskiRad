package com.example.petshealth.visitprescription.model;

import com.example.petshealth.prescriptions.model.Prescriptions;

import com.example.petshealth.visit.model.Visit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "visit_prescription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(VisitPrescritpionId.class)
public class VisitPrescription {

    @Id
    @ManyToOne
    @JoinColumn(name = "visit_id")
    @JsonManagedReference
    private Visit visit;

    @Id
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    @JsonManagedReference
    private Prescriptions prescriptions;

}

