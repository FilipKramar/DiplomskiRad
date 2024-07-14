package com.example.petshealth.visittherapy.model;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitTherapyId implements Serializable {

    private Long visit;
    private Long therapies;
}