package com.yoho.model;

public class ModelSignage implements java.io.Serializable {

	/**
	 * 
	 */
	private int id;
	private String access_type;
	private int is_active;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	public int getIs_active() {
		return is_active;
	}
	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = -6819659187934518053L;
	
	//getter and setter methods
}