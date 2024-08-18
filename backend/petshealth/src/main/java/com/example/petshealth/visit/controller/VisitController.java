package com.example.petshealth.visit.controller;

import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.user.dto.UserLoginDto;
import com.example.petshealth.visit.dto.VisitDetailsAdditionDto;
import com.example.petshealth.visit.dto.VisitDetailsDto;
import com.example.petshealth.visit.dto.VisitScheduleDto;
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

    @GetMapping("vet/{vetid}")
    public ResponseEntity<List<Visit>> listVetsAppointments(@PathVariable Long vetid){
        return ResponseEntity.ok(visitService.listVetsAppointments(vetid));
    }

    @PostMapping()
    public ResponseEntity<Visit> scheduleVisit(@RequestBody VisitScheduleDto visitScheduleDto){

        return ResponseEntity.ok(visitService.scheduleAVisit(visitScheduleDto));
    }

    @PatchMapping("/{id}/{visitId}")
    public ResponseEntity<VisitDetailsDto> addVisitDetails(@PathVariable Long id, @PathVariable Long visitId,@RequestBody VisitDetailsAdditionDto visitDetailsAdditionDto){
        return ResponseEntity.ok(visitService.addVisitDetails(id,visitId,visitDetailsAdditionDto));
    }


}
