package com.example.petshealth.visitprescription.repository;

import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.visit.model.Visit;
import com.example.petshealth.visitprescription.model.VisitPrescription;
import com.example.petshealth.visitprescription.model.VisitPrescritpionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitPrescriptionsRepository extends JpaRepository<VisitPrescription, VisitPrescritpionId> {
    List<VisitPrescription> findByVisit(Visit visit);
}