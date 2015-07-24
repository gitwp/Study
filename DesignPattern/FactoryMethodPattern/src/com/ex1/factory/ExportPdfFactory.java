package com.ex1.factory;

import com.ex1.product.ExportFile;
import com.ex1.product.ExportFinancialPdfFile;
import com.ex1.product.ExportStandardPdfFile;

public class ExportPdfFactory implements ExportFactory {

	@Override
	public ExportFile factory(String type) {
		if ("standard".equals(type)) {

			return new ExportStandardPdfFile();

		} else if ("financial".equals(type)) {

			return new ExportFinancialPdfFile();

		} else {
			throw new RuntimeException("没有找到对象");
		}
	}

}
