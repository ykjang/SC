package com.ibm.swg.sterling.demo;


public class SterlingAPIWrapper {
	
	// 주문생성
	public String createOrder(String input) {
		return invokeAPI("createOrder", input);
	}
	
	// 재고유무
	public String getInventorySupply(String input) {
		return invokeAPI("getInventorySupply", input);
	}
	
	// 주문상세
	public String getOrderDetails(String input) {
		return invokeAPI("getOrderDetails", input);
	}
	
	// 상품등록/수정
	public String manageItem(String input) {
		return invokeAPI("manageItem", input);
	}
	
	// 재고수량변경(누적)
	public String adjustInventory(String input) {
		return invokeAPI("adjustInventory", input);
	}
	
	
	public String invokeAPI(String apiName, String input) {
		SterlingHTTP sterling = new SterlingHTTP();
		sterling.setApi(apiName);
		sterling.setData(input);
		return sterling.run();		
	}
}
