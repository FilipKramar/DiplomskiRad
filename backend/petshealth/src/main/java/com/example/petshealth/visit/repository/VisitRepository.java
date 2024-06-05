package com.example.petshealth.visit.repository;

import com.example.petshealth.visit.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {
}
