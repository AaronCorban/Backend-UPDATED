package com.takeaway.demo.controller;

import com.takeaway.demo.entity.Review;
import com.takeaway.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//api's
//talks to ReviewService class
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    //add a review
    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review review){
        return reviewService.saveReview(review);
    }

    //add list of reviews
    @PostMapping("/reviews")
    public List<Review> addReview(@RequestBody List<Review> reviews){
        return reviewService.saveReviews(reviews);
    }

    //get all reviews in database
    @GetMapping("/reviews")
    public List<Review> findAllReviews(){
        return reviewService.getReviews();
    }

    //get review by id
    @GetMapping("/reviews/{id}")
    public Review findReviewById(@PathVariable long id){
        return reviewService.getReviewById(id);
    }

    //update a review
    @PutMapping("/reviews/{id}")
    public Review updateReview(@RequestBody Review review){
        return reviewService.updateReview(review);
    }

    //delete a review
    @DeleteMapping("/reviews/{id}")
    public String deleteReview(@PathVariable long id){
        return reviewService.deleteReview(id);
    }

}//end class

