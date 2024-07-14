package com.example.petshealth.therapies.service;

import com.example.petshealth.pet.repository.PetRepository;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.prescriptions.repository.PrescriptionRepository;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.therapies.repository.TherapiesRepository;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visit.repository.VisitRepository;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.repository.VisitPrescriptionsRepository;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.example.petshealth.visittherapy.repository.VisitTherapyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TherapiesService {

    private final TherapiesRepository therapiesRepository;

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final VisitTherapyRepository visitTherapyRepository;
    public List<Therapies> listPetsTherapies(Long id) {
        if (petRepository.findById(id).isPresent()) {

            List<Therapies> therapies = new ArrayList<>();
            if (!visitRepository.findByPet(petRepository.findById(id).get()).isEmpty()) {

                List<Visit> visits = visitRepository.findByPet(petRepository.findById(id).get());

                for (Visit visit : visits) {
                    List<VisitTherapy> visitTherapies = visitTherapyRepository.findByVisit(visit);
                    for (VisitTherapy visitTherapy : visitTherapies) {
                        therapies.add(visitTherapy.getTherapies());
                    }
                }
                return therapies;
            } else {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

}
