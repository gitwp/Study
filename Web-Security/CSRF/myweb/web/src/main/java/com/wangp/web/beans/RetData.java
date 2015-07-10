package com.wangp.web.beans;

import java.util.HashMap;
import java.util.Map;

public class RetData {
	public RetData() {
		respInfo = new HashMap<String, Object>();
	}
	private Map<String, Object> respInfo;

	public Map<String, Object> getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(Map<String, Object> respInfo) {
		this.respInfo = respInfo;
	}
	
	public void addObject(String key, Object value) {
		respInfo.put(key, value);
	}

	public void removeObject(String key) {
		respInfo.remove(key);
	}
}
