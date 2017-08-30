package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICES")
public class Device {

	private int id;
	private String deviceName;
	private String deviceLocation;
	private String deviceImageLocation;
	
	@Id
	@GeneratedValue
	@Column(name = "DEVICE_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "device_name")
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	@Column(name = "device_location")
	public String getDeviceLocation() {
		return deviceLocation;
	}

	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}
	@Column(name = "device_image_location")
	public String getDeviceImageLocation() {
		return deviceImageLocation;
	}

	public void setDeviceImageLocation(String deviceImageLocation) {
		this.deviceImageLocation = deviceImageLocation;
	}
	
	
}
