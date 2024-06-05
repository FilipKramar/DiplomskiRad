package com.example.petshealth.veterinarian.service;

import com.example.petshealth.veterinarian.repository.VeterinarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VeterinarianService {

    private final VeterinarianRepository veterinarianRepository;
}
