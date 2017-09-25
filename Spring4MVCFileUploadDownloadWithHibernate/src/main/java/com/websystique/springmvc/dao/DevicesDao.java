package com.websystique.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import com.websystique.springmvc.model.Device;
import com.websystique.springmvc.model.DeviceCategory;

public interface DevicesDao {

	public List<Device> getDevicesByLocation(int deviceLocationId);

	Device findById(int id);

	List<Device> getPrice(ArrayList<Integer> deviceCategory);
	
	public List<Device> getDevicesByLocation(List<Integer> deviceLocationId);
}
