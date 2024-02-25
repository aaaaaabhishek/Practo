package com.Practo.Service;

import com.Practo.Entity.Booking;
import com.Practo.Entity.Doctor;
import com.Practo.Entity.Patient;
import com.Practo.Repositary.BookingRepositary;
import com.Practo.Repositary.DoctorRepository;
import com.Practo.Repositary.PatientRepository;
import com.Practo.config.TimeSlotConfiguration;
import com.Practo.config.TimeSlotManager;
import com.Practo.payLoad.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService {
    @Autowired
    private BookingRepositary bookingRepositary;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private TimeSlotManager timeSlotManager;
@Autowired
private TimeSlotConfiguration timeSlotConfiguration;
    public void bookAnAppointment(BookDto dto) {
        List<String> availableTimeSlots=timeSlotManager.getAvailableTimeSlots();
        Booking booking = new Booking();
        for (String slots : availableTimeSlots) {
            if (slots.equals(dto.getBookingTime())) {
                booking.setBookingTime(String.valueOf(dto.getBookingTime()));
                availableTimeSlots.remove(slots);
                timeSlotManager.setAvailableTimeSlots(availableTimeSlots);
            }
        }
        Doctor doctor = doctorRepository.findById(dto.getDoctorId())
                .orElseThrow(() -> new RuntimeException("DoctorId does not exist: " + dto.getDoctorId()));
        Patient patient = patientRepository.findById(dto.getPatientId()).orElseThrow(() -> new RuntimeException("Patients does not exist" + dto.getPatientId()));
        booking.setDoctorId(dto.getDoctorId());
        booking.setPatientId(dto.getPatientId());
//        if (booking.getBookingTime() != null) {
//            bookingRepositary.save(booking);
//        } else {
//            System.out.println("Tinme slot not Available");
//        }
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        executor.scheduleAtFixedRate(() -> {
//            // Execute code after 24 hours
//            System.out.println("Executing code after 24 hours");
//            availableTimeSlots.add("10:5 AM");
//            availableTimeSlots.add("11.15 AM");
//            availableTimeSlots.add("12:15 Am");
//        }, 24, 24, TimeUnit.HOURS);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            timeSlotConfiguration.initializeTimeSlots();
        }, 24, TimeUnit.HOURS);
    }
}
