package com.example.efootstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;

public interface ReviewDao {
	
	List<Review> getMyReviewList(String userId) throws DataAccessException; 
	
	List<Review> getReviewList() throws DataAccessException; 

	void updateReview(Review review) throws DataAccessException; 
	
	void insertReview(Review review, PointHistory ph) throws DataAccessException, Exception; 
	
	void deleteReview(String revId) throws DataAccessException;

	Review getReview(String revId, PointHistory ph) throws DataAccessException, Exception;

	Review getReview(String revId) throws DataAccessException;

	Review getMyReviewDetail(String revId) throws DataAccessException;
	
	String getMyReview(Review reivew) throws DataAccessException;

	String selectRevId() throws DataAccessException;
}
