package com.example.petshealth.therapies.model;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "therapies")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Therapies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private BigDecimal price;
    private String materials;

    @OneToMany(mappedBy = "therapies")
    @JsonBackReference
    private List<VisitTherapy> visits;

}
