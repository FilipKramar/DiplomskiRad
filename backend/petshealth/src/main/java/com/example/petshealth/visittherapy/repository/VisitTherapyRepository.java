package com.example.petshealth.visittherapy.repository;

import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.model.VisitPrescritpionId;
import com.example.petshealth.visittherapy.model.VisitTherapy;
import com.example.petshealth.visittherapy.model.VisitTherapyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitTherapyRepository extends JpaRepository<VisitTherapy, VisitTherapyId> {
    List<VisitTherapy> findByVisit(Visit visit);
}