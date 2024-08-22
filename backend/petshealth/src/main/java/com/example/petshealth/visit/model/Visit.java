package com.example.petshealth.visit.model;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.veterinarian.model.Veterinarian;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Entity
@Table(name = "visit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id", nullable = false)
    @JsonManagedReference
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    @JsonManagedReference
    private Pet pet;

    @OneToMany(mappedBy = "visit")
    @JsonBackReference
    private List<VisitPrescription> visitPrescriptions;

    @OneToMany(mappedBy = "visit")
    @JsonBackReference
    private List<VisitTherapy> visitTherapies;

    @JoinColumn(name = "visit_date", nullable = false)
    private LocalDate visitDate;

    @JoinColumn(name = "visit_time", nullable = false)
    private LocalTime visitTime;

    private String reason;

    @Column(name = "max_price", precision = 10, scale = 2)
    private BigDecimal maxPrice;
}
