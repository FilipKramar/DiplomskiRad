package com.example.petshealth.user.model;

import com.example.petshealth.pet.model.Pet;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import
jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String email;

    String password;

    String name;

    String surname;

    @Column(name = "oib", columnDefinition = "BPCHAR")
    @NotNull
    @Size(min = 11, max = 11, message = "OIB must be exactly 11 characters long")
    private String oib;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pet> pets;
}
