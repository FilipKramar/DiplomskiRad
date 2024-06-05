package com.example.petshealth.therapies.controller;

import com.example.petshealth.therapies.service.TherapiesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/therapies")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class TherapiesController {

    private  final TherapiesService therapiesService;
}
