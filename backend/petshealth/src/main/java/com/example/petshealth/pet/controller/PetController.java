package com.example.petshealth.pet.controller;

import com.example.petshealth.pet.dto.PetCreationDTO;
import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.pet.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pets")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping()
    public ResponseEntity<Pet> createAPetChart(@RequestBody PetCreationDTO petCreationDTO){

        return ResponseEntity.ok(petService.createAPetChart(petCreationDTO));
    }
}
