package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Device;

public interface DeviceService {

	public List<Device> getDevicesByLocation(int deviceLocationId);
	
	public Device findDeviceById(int id);
}
