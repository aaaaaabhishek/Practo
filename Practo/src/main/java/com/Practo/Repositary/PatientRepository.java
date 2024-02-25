

package com.Practo.Repositary;

import com.Practo.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    // You can define custom query methods if needed
    // For example, you might want to retrieve patients by name, disease, age, etc.
}

