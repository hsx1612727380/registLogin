package com.hsx.util;

import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {
	
	private static String filePath = ""; //XML文件的路径
	
	/**
	 * 获取到文件的路径
	 */
	static {
		URL url = XmlUtil.class.getClassLoader().getResource("user.xml");
		filePath = url.getPath();
	}
	
	/**
	 * 获取XML文件
	 * @return
	 * @throws Exception
	 */
	public static Document getDocument() throws Exception {
		SAXReader saxReader = new SAXReader();
		return saxReader.read(filePath);
	}
	
	/**
	 * 更新XML文件
	 * @param document
	 * @throws Exception
	 */
	public static void write2xml(Document document) throws Exception {
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filePath), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	

}
