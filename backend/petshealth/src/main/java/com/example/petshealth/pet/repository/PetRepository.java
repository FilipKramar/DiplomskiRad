package com.example.petshealth.pet.repository;

import com.example.petshealth.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
