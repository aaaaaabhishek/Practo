package com.Practo.config;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimeSlotManager {
    private List<String> availableTimeSlots;
    public TimeSlotManager(List<String> initialTimeSlots){
        this.availableTimeSlots=initialTimeSlots;
    }
    public List<String> getAvailableTimeSlots(){
        return  availableTimeSlots;
    }

    public void setAvailableTimeSlots(List<String> availableTimeSlots) {
        this.availableTimeSlots=availableTimeSlots;
    }
}
