package com.example.petshealth.prescriptions.repository;

import com.example.petshealth.prescriptions.model.Prescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescriptions,Long> {
}
