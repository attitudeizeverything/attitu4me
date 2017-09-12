package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.ContentPlayingNow;
import com.websystique.springmvc.model.ContentRequest;

public interface ContentPlayingNowService {

	public List<ContentPlayingNow> findByDeviceId(int deviceId);
	
	public void save(ContentPlayingNow contentPlayingNow);
}
