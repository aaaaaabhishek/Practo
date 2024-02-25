package com.Practo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
//@Table(name="Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String diease;
    private int age;

    }
