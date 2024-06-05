package com.example.petshealth.veterinarian.controller;

import com.example.petshealth.veterinarian.service.VeterinarianService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vet")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class VeterinarianController {

    private final VeterinarianService veterinarianService;
}
