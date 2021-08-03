package com.example.efootstore.dao;

import java.util.List;

import com.example.efootstore.domain.PointHistory;

public interface PointHistoryDao {
	
	List<PointHistory> getPointListByUserId(String userId) throws Exception;
	void insertPointHistory(PointHistory ph) throws Exception;
	public void updatePlusPoint(String userId, int point) throws Exception;
	void updateMinusPoint(String userId, int point) throws Exception;
	int getPoint(String userId) throws Exception;
}
