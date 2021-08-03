package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import com.example.efootstore.domain.PointHistory;

public interface PointHistoryMapper {
	List<PointHistory> getPointListByUserId(String userId);
	void insertPointHistory(PointHistory ph);
	void updatePlusPoint(String userId, int point) throws Exception;
	void updateMinusPoint(String userId, int point) throws Exception;
	int getPoint(String userId) throws Exception;
}
