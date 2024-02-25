package com.Practo.payLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookDto {
    private long doctorId;
    private long patientId;
    private Long bookingTime;
}
