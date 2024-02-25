package com.Practo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
    public class TimeSlotConfiguration {

        @Bean
        public TimeSlotManager initializeTimeSlots() {
                List<String> availableTimeSlots = new ArrayList<>();
                availableTimeSlots.add("10:05 AM");
                availableTimeSlots.add("11:15 AM");
                availableTimeSlots.add("12:15 PM");
                   return new TimeSlotManager(availableTimeSlots);
    }
}
