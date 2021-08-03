package com.example.efootstore.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.efootstore.domain.Account;
import com.example.efootstore.domain.GroupBuying;
import com.example.efootstore.domain.Item;

public interface GroupBuyingMapper { 
	
	GroupBuying getGroupBuying(String gbId);
	List<GroupBuying> getGroupBuyingList(); /* ���� ���� �������� ��� ��ȯ*/
	List<GroupBuying> getGroupBuyingListByHeader(String userId); /*����ڰ� �����ϴ� �������� ��� ��ȯ*/
	List<Account> getApplyerOfGroupBuying(String gbId); /*�ش� ���������� ��û�� ��� ��ȯ*/
	List<GroupBuying> getMyGroupBuying(String userId);  /*�ش� ����ڰ� ��û�� �������� ��� ��ȯ*/
	Item getGroupBuyingItem(String gbId);
	
	void insertGroupBuying(GroupBuying gb);
	void insertGroupBuyingItem(Item item);
	
	void updateGroupBuying(GroupBuying gb);
	void updateGroupBuyingItem(Item item);
	
	void deleteGroupBuying(String gbId);
	void deleteGroupBuyingApplyer(String gbId);
	void deleteGroupBuyingItem(String gbId);
	
	void applyGroupBuying(@Param("gbId")String gbId, @Param("userId")String userId); /* �ش� ����ڰ� �ش� �������Ÿ� ��û */
	void cancelApplyGroupBuying(@Param("gbId")String gbId, @Param("userId")String userId); /* �ش� �������Ÿ� ��û�ߴ� �ش� ����ڰ� ��û�� ��� */

}