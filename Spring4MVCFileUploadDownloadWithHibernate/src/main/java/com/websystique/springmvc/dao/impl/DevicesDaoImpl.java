package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.DevicesDao;
import com.websystique.springmvc.model.Device;

@Repository("devicesDao")
public class DevicesDaoImpl extends AbstractDao<Integer, Device> implements DevicesDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Device> getDevicesByLocation(int deviceLocationId) {
		Criteria crit = createEntityCriteria();
		Criteria userCriteria = crit.createCriteria("deviceLocation");
		userCriteria.add(Restrictions.eq("id", deviceLocationId));
		return (List<Device>)crit.list();
	}

	@Override
	public Device findById(int id) {
		return getByKey(id);
	}
	
}
