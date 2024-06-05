package com.example.petshealth.prescriptions.controller;

import com.example.petshealth.prescriptions.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/prescriptions")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class PrescriptionsController {

    private final PrescriptionService prescriptionService;
}
