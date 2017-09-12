package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEVICE_CATEGORY")
public class DeviceCategory {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private int id;
	
	@Column(name = "CATEGORY_TYPE")
	private String category;
	
	@Column(name = "SECONDS_PLAYED")
	private int secondsPlayed;
	
	@Column(name = "NUMBER_OF_TIMES_PLAYED")
	private int numberOfTimesPlayed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSecondsPlayed() {
		return secondsPlayed;
	}
	public void setSecondsPlayed(int secondsPlayed) {
		this.secondsPlayed = secondsPlayed;
	}
	public int getNumberOffTimesPlayed() {
		return numberOfTimesPlayed;
	}
	public void setNumberOffTimesPlayed(int numberOffTimesPlayed) {
		this.numberOfTimesPlayed = numberOffTimesPlayed;
	}
	@Override
	public String toString() {
		return "Device_Category [id=" + id + ", category=" + category + ", secondsPlayed=" + secondsPlayed
				+ ", numberOffTimesPlayed=" + numberOfTimesPlayed + "]";
	}
	
}
