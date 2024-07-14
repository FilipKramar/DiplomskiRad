package com.example.petshealth.prescriptions.controller;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.prescriptions.service.PrescriptionService;
import com.example.petshealth.visit.model.Visit;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/prescriptions")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PrescriptionsController {

    private final PrescriptionService prescriptionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Prescriptions>> listPetsPrescriptions(@PathVariable Long id){
        return ResponseEntity.ok(prescriptionService.listPetsPrescriptions(id));
    }

}
