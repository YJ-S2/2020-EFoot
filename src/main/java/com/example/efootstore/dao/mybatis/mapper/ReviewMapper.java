package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;

public interface ReviewMapper {

	List<Review> getMyReviewList(String userId);

	List<Review> getReviewList();

	void updateReview(Review review);

	void insertReview(Review review);

	Review getReview(String revId);

	void insertReview(Review review, PointHistory ph);

	Review getReview(String revId, PointHistory ph);

	void deleteReview(String revId);

	Review getMyReviewDetail(String revId);

	String getMyReview(Review review);

	String selectRevId();
}
