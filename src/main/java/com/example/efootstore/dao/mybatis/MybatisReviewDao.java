package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.ReviewDao;
import com.example.efootstore.dao.mybatis.mapper.PointHistoryMapper;
import com.example.efootstore.dao.mybatis.mapper.ReviewMapper;
import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;

@Repository
public class MybatisReviewDao implements ReviewDao {
	
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private PointHistoryMapper pointMapper;

	public List<Review> getMyReviewList(String userId) throws DataAccessException {
		return reviewMapper.getMyReviewList(userId);
	}

	public List<Review> getReviewList() throws DataAccessException {
		return reviewMapper.getReviewList();
	}

	public void updateReview(Review review) throws DataAccessException {
		reviewMapper.updateReview(review);
	}

	@Transactional
	public void insertReview(Review review, PointHistory ph) throws Exception {
		reviewMapper.insertReview(review);
		pointMapper.insertPointHistory(ph);
		pointMapper.updatePlusPoint(review.getUserId(), ph.getAmount());
	}

	@Override
	@Transactional
	public Review getReview(String revId, PointHistory ph) throws Exception {
		pointMapper.insertPointHistory(ph);
		pointMapper.updateMinusPoint(ph.getUserId(), ph.getAmount());
		return reviewMapper.getReview(revId);
	}

	@Override
	public void deleteReview(String revId) throws DataAccessException {
		reviewMapper.deleteReview(revId);
		
	}

	@Override
	public Review getReview(String revId) throws DataAccessException {
		return reviewMapper.getReview(revId);
	}

	@Override
	public Review getMyReviewDetail(String revId) {
		return reviewMapper.getMyReviewDetail(revId);
	}

	@Override
	public String getMyReview(Review review) throws DataAccessException {
		return reviewMapper.getMyReview(review);
	}

	@Override
	public String selectRevId() throws DataAccessException {
		return reviewMapper.selectRevId();
	}
	
}
