package com.example.petshealth.pet.service;

import com.example.petshealth.pet.dto.PetCreationDTO;
import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.pet.repository.PetRepository;
import com.example.petshealth.user.model.User;
import com.example.petshealth.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final UserRepository userRepository;
    public Pet createAPetChart(PetCreationDTO petCreationDTO) {
        if (userRepository.findById(petCreationDTO.getUserId()).isPresent()) {
            User user= userRepository.findById(petCreationDTO.getUserId()).get();
            Pet pet = Pet.builder()
                    .name(petCreationDTO.getName())
                    .species(petCreationDTO.getSpecies())
                    .breed(petCreationDTO.getBreed())
                    .microchipnumber(petCreationDTO.getMicrochipNumber())
                    .user(user)
                    .build();

            petRepository.save(pet);
            user.getPets().add(pet);
            userRepository.save(user);
            return pet;
        }
        return null;
    }
}
