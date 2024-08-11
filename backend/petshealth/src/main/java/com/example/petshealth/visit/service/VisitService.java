package com.example.petshealth.visit.service;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.pet.repository.PetRepository;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.visit.dto.VisitDetailsDto;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visit.repository.VisitRepository;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.repository.VisitPrescriptionsRepository;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.example.petshealth.visittherapy.repository.VisitTherapyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VisitService {

    private final VisitRepository visitRepository;

    private final PetRepository petRepository;

    private  final VisitTherapyRepository visitTherapyRepository;

    private final VisitPrescriptionsRepository visitPrescriptionsRepository;
    public List<Visit> listPetsVisits(Long id) {

        Optional<Pet> pet= petRepository.findById(id);

        return visitRepository.findByPet(pet.get());

    }

    public VisitDetailsDto getPetsVisit(long id, Long visitId)
    {
        List<Visit> visits= listPetsVisits(id);

        Visit visit= visits.stream()
                .filter(therapy -> therapy.getId().equals(visitId))
                .findFirst()
                .orElse(null);

        List<VisitTherapy> visitTherapyList= visitTherapyRepository.findByVisit(visit);
        List<Therapies> therapyList = visitTherapyList.stream()
                .map(VisitTherapy::getTherapies)
                .collect(Collectors.toList());

        List<VisitPrescription> visitPrescriptionsList= visitPrescriptionsRepository.findByVisit(visit);

        List<Prescriptions> prescriptionList = visitPrescriptionsList.stream()
                .map(VisitPrescription::getPrescriptions)
                .collect(Collectors.toList());

        VisitDetailsDto visitDetailsDto = new VisitDetailsDto();

        visitDetailsDto.setVisit(visit);
        visitDetailsDto.setTherapies(therapyList);
        visitDetailsDto.setPrescriptions(prescriptionList);


        return visitDetailsDto;






    }
}
