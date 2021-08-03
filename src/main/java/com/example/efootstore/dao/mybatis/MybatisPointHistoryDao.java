package com.example.efootstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.efootstore.dao.PointHistoryDao;
import com.example.efootstore.dao.mybatis.mapper.PointHistoryMapper;
import com.example.efootstore.domain.PointHistory;

@Repository
public class MybatisPointHistoryDao implements PointHistoryDao {

	@Autowired
	private PointHistoryMapper pointHistroyMapper;
	
	@Override
	public List<PointHistory> getPointListByUserId(String userId) {
		return pointHistroyMapper.getPointListByUserId(userId);
	}

	@Override
	public void insertPointHistory(PointHistory ph) {
		pointHistroyMapper.insertPointHistory(ph);
	}

	public void updatePlusPoint(String userId, int point) throws Exception {
		pointHistroyMapper.updatePlusPoint(userId, point);
	}

	@Override
	public void updateMinusPoint(String userId, int point) throws Exception {
		pointHistroyMapper.updateMinusPoint(userId, point);
	}

	@Override
	public int getPoint(String userId) throws Exception {
		return pointHistroyMapper.getPoint(userId);
	}

}
