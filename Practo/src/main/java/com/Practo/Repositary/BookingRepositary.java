package com.Practo.Repositary;

import com.Practo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepositary extends JpaRepository<Booking,Long> {
}
