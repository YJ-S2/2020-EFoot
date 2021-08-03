package com.example.efootstore.dao;

import java.util.List;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.GroupBuying;

public interface GroupBuyingDao {
	GroupBuying getGroupBuying(String gbId);
	List<GroupBuying> getGroupBuyingList(); /* ���� ���� �������� ��� ��ȯ*/
	List<GroupBuying> getGroupBuyingListByHeader(String userId); /*����ڰ� �����ϴ� �������� ��� ��ȯ*/
	List<Account> getApplyerOfGroupBuying(String gbId); /*�ش� ���������� ��û�� ��� ��ȯ*/
	List<GroupBuying> getMyGroupBuying(String userId);  /*�ش� ����ڰ� ��û�� �������� ��� ��ȯ*/
	
	void insertGroupBuying(GroupBuying gb);
	void updateGroupBuying(GroupBuying gb);
	void deleteGroupBuying(String gbId);
	
	void applyGroupBuying(String gbId, String userId); /* �ش� ����ڰ� �ش� �������Ÿ� ��û */
	void cancelApplyGroupBuying(String gbId, String userId); /* �ش� �������Ÿ� ��û�ߴ� �ش� ����ڰ� ��û�� ��� */
	

}
