package com.example.petshealth.visittherapy.model;


import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.visit.model.Visit;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "visit_therapy")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(VisitTherapyId.class)
public class VisitTherapy {

    @Id
    @ManyToOne
    @JoinColumn(name = "visit_id")
    @JsonManagedReference
    private Visit visit;

    @Id
    @ManyToOne
    @JoinColumn(name = "therapy_id")
    @JsonManagedReference
    private Therapies therapies;

}

