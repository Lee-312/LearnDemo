package com.lee.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXReadXml {

	public static void main(String[] args) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode=2004&theUserID=", new DefaultHandler(){

				// xml起始调用
				@Override
				public void startDocument() throws SAXException {
					System.out.println("startDocument");
					super.startDocument();
				}

				// xml结束调用
				@Override
				public void endDocument() throws SAXException {
					System.out.println("endDocument");
					super.endDocument();
				}

				// 元素起始调用
				@Override
				public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
					System.out.println(qName);
					super.startElement(uri, localName, qName, attributes);
				}

				// 元素结束调用
				@Override
				public void endElement(String uri, String localName, String qName) throws SAXException {
					System.out.println(qName);
					super.endElement(uri, localName, qName);
				}

				// 解析器报告字符数据时调用
				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					System.out.println(new String(ch,start,length));
					super.characters(ch, start, length);
				}
			});




		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
}
