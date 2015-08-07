package com.spring.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.spring.enums.AccountEnum;

public class AccountEnumEditor extends PropertyEditorSupport {

	public void setAsText(String text) {
		if (text == null || text.isEmpty()) {
			throw new IllegalArgumentException(
					"account argument status not illegal");
		}

		AccountEnum status = null;
		for (AccountEnum c : AccountEnum.values()) {
			if (c.getIndex() == Integer.parseInt(text)) {
				status = c;
				break;
			}
		}
		
		super.setValue(status);
	}
}
