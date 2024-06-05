package com.example.petshealth.veterinarian.repository;

import com.example.petshealth.veterinarian.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian,Long> {
}
