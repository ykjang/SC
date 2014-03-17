package com.ibm.swg.sterling.demo.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.klab.util.FileContentReader;
import com.ibm.swg.sterling.demo.SterlingAPIWrapper;

public class GetInventorySupply {
	private static final String templateFile = "getInventorySupply.template.xml";
	private String item;
	
	public boolean run() {
		SterlingAPIWrapper api = new SterlingAPIWrapper();
		String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));
		
		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[] { item });
		
		String output = api.getInventorySupply(input);
		
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
		
		//System.out.println(itemCount);
		
		return Double.parseDouble(itemCount) > 0;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
}
