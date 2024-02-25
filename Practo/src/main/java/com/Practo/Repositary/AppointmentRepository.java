package com.Practo.Repositary;

import com.Practo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Booking, Long> {
}
