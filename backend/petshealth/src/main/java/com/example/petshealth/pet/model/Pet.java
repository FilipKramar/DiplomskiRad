package com.example.petshealth.pet.model;

import com.example.petshealth.user.model.User;
import com.example.petshealth.visit.model.Visit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "pets")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String species;

    String breed;

    String name;

    String microchipnumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    User user;

    @OneToMany(mappedBy = "pet")
    private List<Visit> visits;
}
