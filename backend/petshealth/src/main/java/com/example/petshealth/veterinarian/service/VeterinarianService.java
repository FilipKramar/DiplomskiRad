package com.example.petshealth.veterinarian.service;

import com.example.petshealth.user.dto.UserLoginDto;
import com.example.petshealth.user.model.User;
import com.example.petshealth.veterinarian.dto.VeterinarianLoginDto;
import com.example.petshealth.veterinarian.model.Veterinarian;
import com.example.petshealth.veterinarian.repository.VeterinarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeterinarianService {

    private final VeterinarianRepository veterinarianRepository;

    public Long authorizeAnVet(VeterinarianLoginDto veterinarianLoginDto) {

        Optional<Veterinarian> fetchedUser = veterinarianRepository.findByEmail(veterinarianLoginDto.getEmail());

        if (fetchedUser.isEmpty()) {
            throw new RuntimeException("Vet with the username: " + veterinarianLoginDto.getEmail() + "does not exist");
        }
        return fetchedUser.get().getId();
    }

    public List<Veterinarian> getAllVets() {
        return veterinarianRepository.findAll();
    }
}
