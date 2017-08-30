package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.ContentPlayingNow;

public interface ContentPlayingNowService {

	public List<ContentPlayingNow> findByDeviceId(int deviceId);
}
