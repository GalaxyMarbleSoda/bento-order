// OrderDTO.java
package com.example.bentoorder.dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
	private int id;
    private String customerName;
    private List<String> orderItems;
    private int totalAmount;
    private String remark;
    private String ip;
    private Date timeStamp;
    private boolean isChecked;
    
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<String> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
}
