package com.Practo.Controller;

import com.Practo.Service.BookingService;
import com.Practo.payLoad.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingControoler {
    @Autowired
    private BookingService bookingService;
    @PostMapping
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookDto bookDto){
        bookingService.bookAnAppointment(bookDto);
        return new ResponseEntity<>("Booking is confoirm", HttpStatus.CREATED);
    }
//    @PostMapping("/id")
//    public ResponseEntity<String> a(@RequestParam String id){
//        return new ResponseEntity<>(id, HttpStatus.CREATED);
//    }
////    @PostMapping("/{idd}")
////    public ResponseEntity<String> ab(@PathVariable String idd){
////        return new ResponseEntity<>(idd, HttpStatus.CREATED);
////    }
//
//    @PostMapping("/{d}")
//    public ResponseEntity<String> abc(@PathVariable String d){
//        return new ResponseEntity<>(d, HttpStatus.CREATED);
//    }
    @PostMapping("/post")
    public ResponseEntity<String> a(@RequestParam("id") String id,@RequestParam("name") String name){
        return new ResponseEntity<>((id+name), HttpStatus.CREATED);
    }


    }