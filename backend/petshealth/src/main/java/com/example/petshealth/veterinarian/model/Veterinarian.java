package com.example.petshealth.veterinarian.model;

import com.example.petshealth.visit.model.Visit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "veterinarian")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @Column(name = "oib", columnDefinition = "BPCHAR")
    @NotNull
    @Size(min = 11, max = 11, message = "OIB must be exactly 11 characters long")
    private String oib;

    private String password;
    private String email;
    private String veterinaryclinic;
    private Integer yearsofexperience;

    @OneToMany(mappedBy = "veterinarian")
    private List<Visit> visits;

}
