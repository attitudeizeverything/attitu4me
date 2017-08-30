package com.websystique.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.dao.AbstractDao;
import com.websystique.springmvc.dao.ContentPlayingNowDao;
import com.websystique.springmvc.model.ContentPlayingNow;

@Repository("contentPlayingNowDao")
public class ContentPlayingNowDaoImpl extends AbstractDao<Integer, ContentPlayingNow> implements ContentPlayingNowDao{

	@SuppressWarnings("unchecked")
	public List<ContentPlayingNow> findByDeviceId(int deviceId){
		Criteria crit = createEntityCriteria();
		Criteria userCriteria = crit.createCriteria("device");
		userCriteria.add(Restrictions.eq("id", deviceId)).addOrder(Order.asc("startTime"));
		return (List<ContentPlayingNow>)crit.list();
	}

}
