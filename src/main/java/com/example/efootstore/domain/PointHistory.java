package com.example.efootstore.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class PointHistory implements Serializable {

	private String pointId;
	private String userId;
	private Date date;
	private int status;
	private int amount;
	private String history;
	
	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "PointHistory [pointId=" + pointId + ", userId=" + userId + ", date=" + date + ", status=" + status
				+ ", amount=" + amount + ", history=" + history + "]";
	}
	
	
}
