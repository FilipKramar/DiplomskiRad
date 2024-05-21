package com.example.petshealth.user.model;

import
jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
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
}
