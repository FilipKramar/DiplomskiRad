package com.example.petshealth.veterinarian.controller;

import com.example.petshealth.veterinarian.dto.VeterinarianLoginDto;
import com.example.petshealth.veterinarian.service.VeterinarianService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vet")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class VeterinarianController {

    private final VeterinarianService veterinarianService;

    @PostMapping()
    public ResponseEntity<Long> authorizeAnUser(@RequestBody VeterinarianLoginDto veterinarianLoginDto){

        return ResponseEntity.ok(veterinarianService.authorizeAnUser(veterinarianLoginDto));
    }
}
