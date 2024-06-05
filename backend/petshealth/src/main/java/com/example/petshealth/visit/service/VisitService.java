package com.example.petshealth.visit.service;

import com.example.petshealth.visit.repository.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VisitService {

    private final VisitRepository visitRepository;
}
