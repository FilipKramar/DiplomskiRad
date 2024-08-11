package com.example.petshealth.therapies.controller;

import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.therapies.service.TherapiesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/therapies")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class TherapiesController {

    private  final TherapiesService therapiesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Therapies>> listPetsPrescriptions(@PathVariable Long id){
        return ResponseEntity.ok(therapiesService.listPetsTherapies(id));
    }
    @GetMapping("/{id}/{therapiesid}")
    public ResponseEntity<Therapies> getPetsPresciption(@PathVariable Long id, @PathVariable Long therapiesid ){
        return ResponseEntity.ok(therapiesService.getPetsTherapy(id,therapiesid));
    }
}
