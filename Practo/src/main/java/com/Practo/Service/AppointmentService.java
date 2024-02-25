package com.Practo.Service;

import com.Practo.Entity.Booking;
import com.Practo.Repositary.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        return optionalBooking.orElse(null);
    }
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking booking) {

        return booking;
    }
}
