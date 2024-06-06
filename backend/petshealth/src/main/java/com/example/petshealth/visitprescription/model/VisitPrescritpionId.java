package com.example.petshealth.visitprescription.model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitPrescritpionId implements Serializable {
    private Long visit;
    private Long prescriptions;
}