package com.example.efootstore.service;

import java.util.List;

import com.example.efootstore.domain.PointHistory;

public interface PointService {
	void updatePlusPoint(String userId, int point) throws Exception;
	void updateMinusPoint(String userId, int point) throws Exception;
	void insertPointHistory(PointHistory ph) throws Exception;
	List<PointHistory> getPointListByUserId(String userId) throws Exception;
	int getPoint(String userId) throws Exception;
}
