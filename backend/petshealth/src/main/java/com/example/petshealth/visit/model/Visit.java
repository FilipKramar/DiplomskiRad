package com.example.petshealth.visit.model;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.veterinarian.model.Veterinarian;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "visit")
@Data
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
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToMany
    @JoinTable(
            name = "visit_prescription",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "prescription_id")
    )
    private List<Prescriptions> prescriptions;

    @ManyToMany
    @JoinTable(
            name = "visit_therapy",
            joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "therapy_id")
    )
    private List<Therapies> therapies;

    private LocalDate visitDate;

    private String reason;

    @Column(name = "max_price", precision = 10, scale = 2)
    private BigDecimal maxPrice;
}
