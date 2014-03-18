package com.isec.sc.api.omp;

import java.text.MessageFormat;

import com.isec.sc.api.core.SterlingHTTPConnector;
import com.isec.sc.api.core.util.FileContentReader;

public class CreateOrder {
	
	private static final String apiName = "createOrder"; // API Name
	private static final String templateFile = "createOrder.template.xml"; // API Input Template
	
	
	// API Input Attribute
	private String personName; // 구매자
	private String address;    // 배송지 주소
	private String item;	   // 상품ID
	private double quantity;   // 구매수량
	private String orderNo;    // 주문번호
	
	
	public void run() {
		String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));
		
		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[] { personName, address, item, Double.toString(quantity), orderNo});
		
		//  API 호출
		SterlingHTTPConnector sterling = new SterlingHTTPConnector();
		sterling.setApi(apiName);
		sterling.setData(input);
		sterling.run();
		
	}
	
	// getter/setter
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
}
