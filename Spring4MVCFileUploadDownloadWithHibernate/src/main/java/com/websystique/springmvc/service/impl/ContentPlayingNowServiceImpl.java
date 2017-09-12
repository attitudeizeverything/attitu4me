package com.websystique.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.ContentPlayingNowDao;
import com.websystique.springmvc.model.ContentPlayingNow;
import com.websystique.springmvc.model.ContentRequest;
import com.websystique.springmvc.service.ContentPlayingNowService;

@Service("contentPlayingNowService")
@Transactional
public class ContentPlayingNowServiceImpl implements ContentPlayingNowService {

	@Autowired
	ContentPlayingNowDao dao;
	
	public List<ContentPlayingNow> findByDeviceId(int deviceId){
		return dao.findByDeviceId(deviceId);
	}

	@Override
	public void save(ContentPlayingNow contentPlayingNow) {
		dao.save(contentPlayingNow);
		
	} 
	
	
}
