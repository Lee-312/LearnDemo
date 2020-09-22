package com.lee.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateMyXml {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Element root = document.createElement("myElement");
			Element name = document.createElement("name");
			name.setTextContent("lee");
			Element age = document.createElement("age");
			age.setTextContent("2333");
			document.appendChild(root);
			root.appendChild(name);
			root.appendChild(age);

			// 创建TransformerFactory对象
			TransformerFactory tff = TransformerFactory.newInstance();
			// 创建 Transformer对象
			Transformer tf = tff.newTransformer();

			// 输出内容是否使用换行
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			// 创建xml文件并写入内容
			tf.transform(new DOMSource(document), new StreamResult(new File("book1.xml")));
			System.out.println("生成book1.xml成功");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
