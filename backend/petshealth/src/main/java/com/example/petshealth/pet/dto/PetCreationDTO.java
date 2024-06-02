package com.example.petshealth.pet.dto;

import com.example.petshealth.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetCreationDTO {

    String species;

    String breed;

    String name;

    String microchipNumber;

    Long userId;
}
