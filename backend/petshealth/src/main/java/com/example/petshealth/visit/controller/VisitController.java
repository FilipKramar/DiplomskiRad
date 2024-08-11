package com.example.petshealth.visit.controller;

import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.visit.dto.VisitDetailsDto;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visit.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/visit")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Visit>> listPetsVisits(@PathVariable Long id){
        return ResponseEntity.ok(visitService.listPetsVisits(id));
    }


    @GetMapping("/{id}/{visitId}")
    public ResponseEntity<VisitDetailsDto> listPetsVisits(@PathVariable Long id, @PathVariable Long visitId){
        return ResponseEntity.ok(visitService.getPetsVisit(id,visitId));
    }

}
