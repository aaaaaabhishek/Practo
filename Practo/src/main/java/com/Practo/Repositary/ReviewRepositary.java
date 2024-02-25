package com.Practo.Repositary;

import com.Practo.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepositary extends JpaRepository<Review,Long> {
    List<Review> findByDoctorId(long doctorId);
}
