package com.example.efootstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.efootstore.dao.PointHistoryDao;
import com.example.efootstore.domain.PointHistory;

@Service
@Transactional
public class PointServiceImpl implements PointService {
	@Autowired
	private PointHistoryDao pointDao;
	
	
	public void updatePlusPoint(String userId, int point) throws Exception {
		pointDao.updatePlusPoint(userId, point);
	}


	@Override
	public void insertPointHistory(PointHistory ph) throws Exception {
		pointDao.insertPointHistory(ph);
	}
	
	@Override
	public void updateMinusPoint(String userId, int point) throws Exception {
		pointDao.updateMinusPoint(userId, point);
	}


	@Override
	public List<PointHistory> getPointListByUserId(String userId) throws Exception {
		return pointDao.getPointListByUserId(userId);
	}

	@Override
	public int getPoint(String userId) throws Exception {
		return pointDao.getPoint(userId);
	}


}
