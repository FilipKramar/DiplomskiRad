package com.example.petshealth.prescriptions.service;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.pet.repository.PetRepository;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.prescriptions.repository.PrescriptionRepository;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visit.repository.VisitRepository;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.repository.VisitPrescriptionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final VisitPrescriptionsRepository visitPrescriptionsRepository;
    public List<Prescriptions> listPetsPrescriptions(Long id) {
        if (petRepository.findById(id).isPresent()) {

            List<Prescriptions> prescriptions = new ArrayList<>();
            if (!visitRepository.findByPet(petRepository.findById(id).get()).isEmpty()) {

                List<Visit> visits = visitRepository.findByPet(petRepository.findById(id).get());

                for (Visit visit : visits) {
                    List<VisitPrescription> visitPrescriptions = visitPrescriptionsRepository.findByVisit(visit);
                    for (VisitPrescription visitPrescription : visitPrescriptions) {
                        prescriptions.add(visitPrescription.getPrescriptions());
                    }
                }
                return prescriptions;
            } else {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    public Prescriptions getPetsPrescription(Long id, Long prescriptionid) {
        List<Prescriptions> prescriptionList= listPetsPrescriptions(id);
        return prescriptionList.stream()
                .filter(therapy -> therapy.getId().equals(prescriptionid))
                .findFirst()
                .orElse(null);
    }
}

