package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.ContentPlayingNow;

public interface ContentPlayingNowDao {

	public List<ContentPlayingNow> findByDeviceId(int deviceId);
}
