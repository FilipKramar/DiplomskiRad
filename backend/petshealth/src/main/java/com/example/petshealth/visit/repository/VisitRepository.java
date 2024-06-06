package com.example.petshealth.visit.repository;

import com.example.petshealth.pet.model.Pet;
import com.example.petshealth.visit.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit,Long> {
    List<Visit> findByPet(Pet pet);
}

