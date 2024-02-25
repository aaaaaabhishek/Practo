package com.Practo.Repositary;

import com.Practo.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface  DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("SELECT d FROM Doctor d WHERE d.name Like %:search% OR d.specilizations LIKE %:search%")
    List<Doctor> searchByNameOrSpecilizations(@Param("search")String search);
}
