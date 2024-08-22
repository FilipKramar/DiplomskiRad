package com.example.petshealth.visit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitScheduleDto {

    Long vetId;
    Long petId;
    LocalDate visitDate;
    LocalTime visitTime;

    }