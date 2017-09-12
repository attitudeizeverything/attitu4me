package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.Device;

public interface DevicesDao {

	public List<Device> getDevicesByLocation(int deviceLocationId);

	Device findById(int id);
}
