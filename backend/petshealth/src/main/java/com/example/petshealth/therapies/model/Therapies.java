package com.example.petshealth.therapies.model;
import com.example.petshealth.visit.model.Visit;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "therapies")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Therapies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String type;
    private BigDecimal price;
    private String materials;

    @ManyToMany(mappedBy = "therapies")
    private List<Visit> visits;
}
