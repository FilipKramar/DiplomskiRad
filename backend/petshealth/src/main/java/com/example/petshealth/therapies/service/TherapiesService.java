package com.example.petshealth.therapies.service;

import com.example.petshealth.therapies.repository.TherapiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TherapiesService {

    private final TherapiesRepository therapiesRepository;
}
