package com.example.petshealth.prescriptions.repository;

import com.example.petshealth.prescriptions.model.Prescriptions;
import com.example.petshealth.visit.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescriptions,Long> {

}
