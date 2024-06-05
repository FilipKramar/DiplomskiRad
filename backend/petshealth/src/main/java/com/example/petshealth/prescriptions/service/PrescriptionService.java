package com.example.petshealth.prescriptions.service;

import com.example.petshealth.prescriptions.repository.PrescriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
}
