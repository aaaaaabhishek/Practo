package com.Practo.payLoad;

import com.Practo.Entity.Doctor;
import com.Practo.Entity.Review;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDto {
   private Doctor doctor;
   private List<Review> reviews;
   private Double ratingPercentage;
}
