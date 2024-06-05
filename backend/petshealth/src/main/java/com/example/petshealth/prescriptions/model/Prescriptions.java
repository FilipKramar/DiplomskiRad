package com.example.petshealth.prescriptions.model;

import com.example.petshealth.visit.model.Visit;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prescriptions")
@Data
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

    @ManyToMany(mappedBy = "prescriptions")
    private List<Visit> visits;
}
