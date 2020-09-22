package com.lee.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import lombok.Data;

public class ReadXml {
	/**
	 * <ArrayOfString xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns="http://WebXml.com.cn/">
	 * <string>江苏 苏州</string>
	 * <string>苏州</string>
	 * <string>2004</string>
	 * <string>2020/08/04 20:28:00</string>
	 * <string>今日天气实况：气温：26℃；风向/风力：东北风 2级；湿度：92%</string>
	 * <string>紫外线强度：最弱。</string>
	 * <string>中国人民保险中暑指数：无中暑风险，天气不热，在炎炎夏日中十分难得，可以告别暑气漫漫啦~ 健臻·血糖指数：易波动，风力较大，血糖易波动，注意监测。 穿衣指数：炎热，建议穿短衫、短裤等清凉夏季服装。 洗车指数：不宜，有雨，雨水和泥水会弄脏爱车。 紫外线指数：最弱，辐射弱，涂擦SPF8-12防晒护肤品。 </string>
	 * <string>8月4日 阵雨转中雨</string>
	 * <string>27℃/34℃</string>
	 * <string>东南风4-5级</string>
	 * <string>3.gif</string>
	 * <string>8.gif</string>
	 * <string>8月5日 小雨转多云</string>
	 * <string>28℃/33℃</string>
	 * <string>东南风4-5级</string>
	 * <string>7.gif</string>
	 * <string>1.gif</string>
	 * <string>8月6日 多云</string>
	 * <string>28℃/35℃</string>
	 * <string>东南风3-4级</string>
	 * <string>1.gif</string>
	 * <string>1.gif</string>
	 * <string>8月7日 多云</string>
	 * <string>29℃/36℃</string>
	 * <string>东南风3-4级</string>
	 * <string>1.gif</string>
	 * <string>1.gif</string>
	 * <string>8月8日 阴转多云</string>
	 * <string>29℃/36℃</string>
	 * <string>东南风3-4级</string>
	 * <string>2.gif</string>
	 * <string>1.gif</string>
	 * </ArrayOfString>
	 */
	public static void main(String[] args) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document parse = builder.parse("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getWeather?theCityCode=2004&theUserID=");
			NodeList root = parse.getChildNodes();
			for (int i = 0; i < root.getLength(); i++) {
				Node node = root.item(i);
				NodeList nodes = node.getChildNodes();
				for (int j = 0; j < nodes.getLength(); j++) {
					if(nodes.item(j) instanceof Element){
						Element element = (Element) nodes.item(j);
//						System.out.println("标签名："+element.getTagName());
//						System.out.println("标签属性："+element.getNodeValue());
						System.out.println("内容："+element.getTextContent());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
@Data
class Weather{
	private String cityParent;
	private String cityName;
	private String cityId;
	private String time;
	private String weatherInfo;
	private String weatherRays;
	private String advise;

	private String todayWeather;
	private String todayTemperature;
	private String todayWind;
	private String todayGif1;
	private String todayGif2;

	private String tomorrowWeather;
	private String tomorrowTemperature;
	private String tomorrowWind;
	private String tomorrowGif1;
	private String tomorrowGif2;

	private String afterTomorrowWeather;
	private String afterTomorrowTemperature;
	private String afterTomorrowWind;
	private String afterTomorrowGif1;
	private String afterTomorrowGif2;

	private String threeDaysWeather;
	private String threeDaysTemperature;
	private String threeDaysWind;
	private String threeDaysGif1;
	private String threeDaysGif2;

	private String fourDaysWeather;
	private String fourDaysTemperature;
	private String fourDaysWind;
	private String fourDaysGif1;
	private String fourDaysGif2;

}
