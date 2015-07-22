package org.common;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class BaseEntity implements Serializable {

	protected static final long serialVersionUID = 1L;

	public String toJsonString() {
		return JSONObject.fromObject(this).toString();
	}

}
