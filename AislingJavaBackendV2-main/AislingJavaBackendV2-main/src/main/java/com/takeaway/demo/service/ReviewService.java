package com.takeaway.demo.service;

import com.takeaway.demo.dao.ReviewRepository;
import com.takeaway.demo.entity.Review;
import com.takeaway.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//business logic
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    //save review
    public Review saveReview(Review review){
        return reviewRepository.save(review);
    }

    //save list of reviews
    public List<Review> saveReviews(List<Review> reviews){
        return reviewRepository.saveAll(reviews);
    }

    //get all reviews from database
    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    //get review by id
    public Review getReviewById(long reviewID){
        return this.reviewRepository.findById(reviewID).orElseThrow(() -> new ResourceNotFoundException("Review not found: " + reviewID));
    }

    //delete review
    public String deleteReview(long id){
        reviewRepository.deleteById(id);
        return "Review " + id +" deleted.";
    }

    //update review
    public Review updateReview(Review review){
        Review existingReview = reviewRepository.findById(review.getId()).orElse(null);
        existingReview.setName(review.getName());
        existingReview.setRating(review.getRating());
        existingReview.setComment(review.getComment());
        existingReview.setCreationDate(review.getCreationDate());
        return reviewRepository.save(existingReview);
    }
}
