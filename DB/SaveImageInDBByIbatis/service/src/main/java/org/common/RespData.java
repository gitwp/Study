package org.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.common.constants.MessageCode;
import org.common.exception.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RespData extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private ErrorInfo errorInfo;
	private Map<String, Object> respInfo;
	protected transient Logger log = LoggerFactory.getLogger(this.getClass());

	public RespData() {
		respInfo = new HashMap<String, Object>();
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		if(errorInfo != null && !StringUtils.isBlank(errorInfo.getErrorCode()) 
				&& !errorInfo.getErrorCode().equals(MessageCode.M0000)) {
			log.error(errorInfo.getErrorCode() + errorInfo.getErrorMessage());
		}
		this.errorInfo = errorInfo;
	}

	public Map<String, Object> getRespInfo() {
		return respInfo;
	}

	public void setRespInfo(Map<String, Object> respInfo) {
		this.respInfo = respInfo;
	}

	public void setSuccess(MessageSourceAccessor msa) {
		this.setErrorInfo(new ErrorInfo(MessageCode.M0000, msa
				.getMessage(MessageCode.M0000)));
	}

	public void setSysError(MessageSourceAccessor msa) {
		this.setErrorInfo(new ErrorInfo(MessageCode.M9999, msa
				.getMessage(MessageCode.M9999)));
	}

	public void addObject(String key, Object value) {
		respInfo.put(key, value);
	}

	public void removeObject(String key) {
		respInfo.remove(key);
	}
}
