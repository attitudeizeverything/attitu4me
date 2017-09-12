package com.websystique.springmvc.model;

import java.util.Date;

public class ContentRequest {

	private int deviceId;
	private int contnetId;
	private Date date;
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getContnetId() {
		return contnetId;
	}
	public void setContnetId(int contnetId) {
		this.contnetId = contnetId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
