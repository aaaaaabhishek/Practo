package com.Practo.Service;

import com.Practo.Entity.Doctor;
import com.Practo.Entity.Patient;
import com.Practo.Entity.Review;
import com.Practo.Repositary.DoctorRepository;
import com.Practo.Repositary.PatientRepository;
import com.Practo.Repositary.ReviewRepositary;
import com.Practo.payLoad.DoctorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private ReviewRepositary reviewRepos;
    Logger logger = LoggerFactory.getLogger(ReviewService.class);
    public ResponseEntity<Review> createReview(Review review){
        Doctor doctor=doctorRepo.findById(review.getDoctorId()).get();
        Patient patient=patientRepo.findById(review.getPatientId()).get();
        Review saveReview = null;
        if ((doctor != null || patient != null) && review.getRating() <= 5) {
            saveReview = reviewRepos.save(review);
            return new ResponseEntity<>(saveReview, HttpStatus.OK);
        } else {
            logger.warn("Review not saved. Doctor or patient not found, or invalid rating.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
    List<DoctorDto> dtos = new ArrayList<>();

    public List<DoctorDto> getReviewDoctorId(long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId).orElse(null);
        List<Review> reviews = reviewRepos.findByDoctorId(doctorId);
        double totalrating=0;
        for (Review review:reviews){
            totalrating+=review.getRating();
        }
        double averageRating=totalrating/reviews.size();
        double ratingPercentage=(averageRating/5.0)*100.0;
        if (doctor != null) {
            DoctorDto dto = new DoctorDto();
            dto.setDoctor(doctor);
            dto.setReviews(reviews);
            dto.setRatingPercentage(ratingPercentage);
            dtos.add(dto);
            return dtos;
//            return Collections.singletonList(dto);
        } else {
            return Collections.emptyList(); // Return an empty list if doctor is not found
        }
    }
}
