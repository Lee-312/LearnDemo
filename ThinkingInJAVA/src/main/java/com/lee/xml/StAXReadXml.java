package com.lee.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class StAXReadXml {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode=2004&theUserID=");
			InputStream in = url.openStream();
			XMLInputFactory factory = XMLInputFactory.newFactory();
			XMLStreamReader reader = factory.createXMLStreamReader(in);
			while (reader.hasNext()) {
				int event = reader.next();
				//System.out.println(reader.getElementText());
				System.out.println(reader.getAttributeCount());
				System.out.println(1);
//				if (event == XMLStreamReader.START_ELEMENT) {
//					if (reader.getLocalName().equals("string")) {
//						String s = reader.getAttributeValue(null, "string");
//						System.out.println(s);
//					}
//				}
			}
		} catch (Exception e) {

		}


	}
}
