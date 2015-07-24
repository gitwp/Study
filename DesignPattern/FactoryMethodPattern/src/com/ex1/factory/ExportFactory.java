package com.ex1.factory;

import com.ex1.product.ExportFile;
/**
 * 抽象工厂
 */
public interface ExportFactory {
	public ExportFile factory(String type);
}
