package com.example.petshealth.therapies.repository;

import com.example.petshealth.therapies.model.Therapies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TherapiesRepository extends JpaRepository<Therapies,Long> {
}
