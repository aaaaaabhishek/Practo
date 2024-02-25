package com.Practo.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//@ManyToOne
//@JoinColumn(name="docter_id",referencedColumnName = "id")
//private Doctor doctor;
//    private String doctorName;
//@Column(nullable = false)
//    private LocalDateTime dateTime;
//@Column(nullable = false)
//private boolean morningSlotAvailable;
//    @Column(nullable = false)
//    private boolean afternoonSlotAvailable;
//    @Column(nullable = false)
//    private boolean eveningSlotAvailable;
//    private String patientName;
////    private String slotType; // This field can be "Morning", "Afzzternoon", or "Evening"

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
private long doctorId;
private long patientId;
private String bookingTime;
}
