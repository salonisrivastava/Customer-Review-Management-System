package com.capgemini.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.bookstore.dao.ReviewRepository;
import com.capgemini.bookstore.entity.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public Review addReview(Review reviews) {
		return reviewRepository.save(reviews);
	}

	@Override
	public List<Review> viewAllReview() {
		return reviewRepository.findAll();
	}

	@Override
	public Review viewReview(Integer reviewId) {
		if(reviewRepository.findById(reviewId).isPresent())
            return reviewRepository.findById(reviewId).get();
        return null;
	}

	
	@Override
	public Review updateReview(Review reviews) {
		if (reviewRepository.existsById(reviews.getReviewId())) {
			
			return reviewRepository.save(reviews);
		}
		return reviews;
	}
	@Override
	public void deleteReview(Integer reviewId) {
		if(reviewRepository.findById(reviewId).isPresent()){
			reviewRepository.deleteById(reviewId);
        }
		
	}

	

}
