package com.spring.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.common.des.DESUtils;

public class EncryptPropertyPlaceholderConfigure extends
		PropertyPlaceholderConfigurer {

	private String[] encryptProNames = {"encrypt_username","encrypt_password"};

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if(isEncryptPro(propertyName)){
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			return decryptValue;
		}
		return propertyValue;
	}
	
	/**
	 * 判断是否属性是否是加密过的
	 * @param propertyName
	 * @return
	 */
	private boolean isEncryptPro(String propertyName){
		for(String str : encryptProNames){
			if(str.equals(propertyName)){
				return true;
			}
		}
		return false;
	}
}
