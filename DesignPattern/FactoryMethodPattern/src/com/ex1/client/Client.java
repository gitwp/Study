package com.ex1.client;

import com.ex1.factory.ExportFactory;
import com.ex1.factory.ExportHtmlFactory;
import com.ex1.product.ExportFile;

public class Client {
	/**
     * @param args
     */
    public static void main(String[] args) {
        String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
    }
}
