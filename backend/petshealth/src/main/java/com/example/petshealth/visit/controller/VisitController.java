package com.example.petshealth.visit.controller;

import com.example.petshealth.visit.service.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/visit")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class VisitController {

    private final VisitService visitService;
}
