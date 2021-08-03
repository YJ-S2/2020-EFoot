package com.example.efootstore.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;

public interface ReviewService {
	
	List<Review> getMyReviewList(String userId);

	List<Review> getReviewList();
	
	Review getReview(String revId, PointHistory ph) throws DataAccessException, Exception;
	
	void updateReview(Review review);

	void deleteReview(String revId);

	void insertReview(Review review, PointHistory ph) throws DataAccessException, Exception;

	Review getReview(String revId);

	Review getMyReviewDetail(String revId);

	String getMyReview(Review review);
	
	String selectRevId();
}
