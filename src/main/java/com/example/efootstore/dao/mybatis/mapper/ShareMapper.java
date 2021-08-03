package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.Item;
import com.example.efootstore.domain.Share;

public interface ShareMapper {
	Share getShare(String shId);

	List<Share> getShareList();
	
	List<Share> getShareListByHeader(String userId);
	
	List<Account> getApplyerOfShare(String shId) ; /*����ǰ�� ��û�� ����Ʈ �ҷ�����*/

	List<Share> getMyShare(String userId);  /*�ش� ������� ��û�� ��������Ʈ*/	

	Item getShareItem(String gbId);

	void insertShare(Share sh);
	void insertShareItem(Share sh);
	
	void updateShare(Share sh);
	void updateShareItem(Share sh);
	
	void deleteShareItem(String shId);
	void deleteShare(String ShId);
	void deleteShareApplyer(String shId);
	
	void applyShare(@Param("shId")String shId, @Param("userId")String userId); /* �����(userId)�� ����(shId)�� ��û ����*/
	void cancelApplyShare(@Param("shId")String shId, @Param("userId")String userId); /* �����(userId)�� ����(shId) ��û  ���� ��� */
}
