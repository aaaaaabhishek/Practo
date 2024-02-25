package com.Practo.Controller;

import com.Practo.Entity.Review;
import com.Practo.Repositary.DoctorRepository;
import com.Practo.Service.ReviewService;
import com.Practo.payLoad.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
@Autowired
private DoctorRepository doctorRepository;
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<List<DoctorDto>> getReviewsByDoctorId(@PathVariable long doctorId){
        return new ResponseEntity<>( reviewService.getReviewDoctorId(doctorId), HttpStatus.CREATED);
    }

}
