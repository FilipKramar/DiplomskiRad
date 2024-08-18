package com.example.petshealth.visit.service;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.pet.repository.PetRepository;
import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.prescriptions.repository.PrescriptionRepository;
import com.example.petshealth.therapies.model.Therapies;
import com.example.petshealth.therapies.repository.TherapiesRepository;
import com.example.petshealth.user.model.User;
import com.example.petshealth.veterinarian.model.Veterinarian;
import com.example.petshealth.veterinarian.repository.VeterinarianRepository;
import com.example.petshealth.visit.dto.VisitDetailsAdditionDto;
import com.example.petshealth.visit.dto.VisitDetailsDto;
import com.example.petshealth.visit.dto.VisitScheduleDto;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visit.repository.VisitRepository;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.repository.VisitPrescriptionsRepository;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.example.petshealth.visittherapy.repository.VisitTherapyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private final VeterinarianRepository veterinarianRepository;

    private final PrescriptionRepository prescriptionRepository;

    private final TherapiesRepository therapiesRepository;
    public List<Visit> listPetsVisits(Long id) {

        Optional<Pet> pet= petRepository.findById(id);

        return visitRepository.findByPet(pet.get());

    }

    public VisitDetailsDto getPetsVisit(long id, Long visitId)
    {
        List<Visit> visits= listPetsVisits(id);

        Visit visit= visits.stream()
                .filter(fetchedVisitId -> fetchedVisitId.getId().equals(visitId))
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

    public List<Visit> listVetsAppointments(Long id) {

        Veterinarian vet= veterinarianRepository.findById(id).get();

        return visitRepository.findByVeterinarian(vet);

    }

    public Visit scheduleAVisit(VisitScheduleDto visitScheduleDto) {

        Visit visit = Visit.builder()
                .veterinarian(veterinarianRepository.findById(visitScheduleDto.getVetId()).get())
                .pet(petRepository.findById(visitScheduleDto.getPetId()).get())
                .visitDate(LocalDate.now())
                .build();

        visitRepository.save(visit);
        return visit;
    }
    @Transactional
    public VisitDetailsDto addVisitDetails(Long id, Long visitId , VisitDetailsAdditionDto visitDetailsAdditionDto) {

        List<Visit> visits= listPetsVisits(id);

        Visit visit= visits.stream()
                .filter(fetchedVisitId -> fetchedVisitId.getId().equals(visitId))
                .findFirst()
                .orElse(null);

        List<Prescriptions> fetchedPrescriptionList= prescriptionRepository.findAllById(visitDetailsAdditionDto.getPrescriptionId());

        fetchedPrescriptionList.forEach(prescription -> {
           VisitPrescription visitPrescription= new VisitPrescription( visitRepository.findById(visitId).get(), prescription);
           visitPrescriptionsRepository.save(visitPrescription);
           visit.getVisitPrescriptions().add(visitPrescription);
        });

        List<Therapies> fetchedTherapiesList= therapiesRepository.findAllById(visitDetailsAdditionDto.getTherapyId());

        fetchedTherapiesList.forEach(therapy -> {
            VisitTherapy visitTherapy= new VisitTherapy( visitRepository.findById(visitId).get(), therapy);
            visitTherapyRepository.save(visitTherapy);
            visit.getVisitTherapies().add(visitTherapy);
        });


        visitRepository.save(visit);

        return getPetsVisit(id,visitId);
    }
}
