package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.ReviewDao;
import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	public List<Review> getReviewList() {
		return reviewDao.getReviewList();
	}

	public Review getReview(String revId, PointHistory ph) throws DataAccessException, Exception {
		return reviewDao.getReview(revId, ph);
	}

	public void updateReview(Review review) {
		reviewDao.updateReview(review);
	}

	public void deleteReview(String revId) {
		reviewDao.deleteReview(revId);
	}

	public void insertReview(Review review, PointHistory ph) throws DataAccessException, Exception {
		reviewDao.insertReview(review, ph);
	}

	public List<Review> getMyReviewList(String userId) {
		return reviewDao.getMyReviewList(userId);
	}

	@Override
	public Review getReview(String revId) {
		return reviewDao.getReview(revId);
	}

	@Override
	public Review getMyReviewDetail(String revId) {
		return reviewDao.getMyReviewDetail(revId);
	}

	@Override
	public String getMyReview(Review review) {
		return reviewDao.getMyReview(review);
	}

	@Override
	public String selectRevId() {
		return reviewDao.selectRevId();
	}
}
