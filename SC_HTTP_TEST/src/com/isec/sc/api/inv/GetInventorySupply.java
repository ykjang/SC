package com.isec.sc.api.inv;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.isec.sc.api.core.SterlingHTTPConnector;
import com.isec.sc.api.core.util.FileContentReader;

public class GetInventorySupply {
	
	private static final String apiName = "getInventorySupply"; // API Name
	private static final String templateFile = "getInventorySupply.template.xml"; // API Input Template
	
	private String item; // 아아템ID
	
	public boolean run() {
		String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));
		
		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[] { item });
		
		
		// API 호출
		SterlingHTTPConnector sterling = new SterlingHTTPConnector();
		sterling.setApi(apiName);
		sterling.setData(input);
		String output = sterling.run();
		
		
		// Output XML Parsing
		Document doc = null;

		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(output.getBytes()));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = doc.getDocumentElement();
		Element supplyNode = (Element) root.getElementsByTagName("InventorySupply").item(0);
		if (supplyNode == null)	return false;
		
		String itemCount = supplyNode.getAttribute("Quantity");		
		
		// 재고수량이 0보다 클 경우 true ELSE false 리턴
		return Double.parseDouble(itemCount) > 0;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
