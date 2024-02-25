package com.Practo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 private String name;
 private String qualification ;
 private String specilizations;
 private int experience;
 private String description;
}
