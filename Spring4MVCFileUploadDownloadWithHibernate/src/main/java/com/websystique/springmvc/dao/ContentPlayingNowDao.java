package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.ContentPlayingNow;
import com.websystique.springmvc.model.ContentRequest;

public interface ContentPlayingNowDao {

	public List<ContentPlayingNow> findByDeviceId(int deviceId);
	
	public void save(ContentPlayingNow contentPlayingNow);
}
