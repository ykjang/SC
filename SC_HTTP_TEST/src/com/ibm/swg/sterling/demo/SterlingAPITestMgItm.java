package com.ibm.swg.sterling.demo;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.ibm.klab.util.FileContentReader;
import com.ibm.swg.sterling.demo.api.CreateOrder;
import com.ibm.swg.sterling.demo.api.GetInventorySupply;
import com.ibm.swg.sterling.demo.api.GetOrderStatus;
import com.ibm.swg.sterling.demo.api.ManageItem;

public class SterlingAPITestMgItm {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
/*
		// Order 생성
		CreateOrder co = new CreateOrder();
		co.setPersonName("Barack Obama");
		co.setAddress("Washington DC");
		co.setItem("100125");
		co.setQuantity(2);
		co.setOrderNo("MYORDERNO");
		co.run();
*/
		
/*		
		// 아이템 재고정보 정회
		GetInventorySupply is = new GetInventorySupply();
		is.setItem("100125");
		boolean result = is.run();
		System.out.println(result);
*/
		
/*		
		// Order Status 조회
		GetOrderStatus os = new GetOrderStatus();
		os.setEnterpriseCd("Matrix");
		os.setOrderNo("Y100000212");
		os.run();
*/		
		
		
		/* 
		 * Cube -> SC 상품정보 연동(등록,수정)
		 * 
		 * 1. 동기화할 상품정보 조회 (DB, File)
		 * 2. ManageItem객체형 ArrayList로 저장
		 * 3. manageItem API invoke
		 */
		
		// Sample Data
		String[] arr_bar_code = {"GRA122A010BLML","GRA122A010BLXSS","GRA122A01GORML", "GRA122A01GORXSS"};
		String[] arr_brand_id = {"SD","AE","RL","TH"};
		String[] arr_brand_name = {"SuperDry","American Eagle","Ralph Rauren","Tommy"};
		Double[] arr_sale_price = {1500.00, 1600.00, 1700.00, 1800.00};
		String[] arr_pname = {"Jacket","Shirts","Pants","Polo"};
		String[] arr_item_color = {"BL","BL","OR", "OR"};
		String[] arr_item_size = {"ML","XSS","ML", "XSS"};
		
		
		ArrayList<ManageItem> itemList = new ArrayList<ManageItem>(); 
		for(int i=0; i<arr_bar_code.length; i++){
			ManageItem mi = new ManageItem();
			mi.setAction("Manage");						// 고정값
			mi.setGlobalItemID(""); 					// 현재는 ""처리
			mi.setItemID(arr_bar_code[i]);				// bar_code
			mi.setOrganizationCode("Matrix");			// 고정값(조직코드)
			mi.setUnitOfMeasure("EACH");				// 고정값
			mi.setEffectiveStartDate("2014-03-12");		// 현재일
			mi.setEffectiveEndDate("9999-12-31");		// 고정값
			mi.setManufacturerItem(arr_brand_id[i]);	// brand_id
			mi.setManufacturerName(arr_brand_name[i]);	// brand_name
			mi.setUnitCost(arr_sale_price[i]);			// sale_price(최초판매가)
			mi.setShortDescription(arr_pname[i]);		// pname
			mi.setColorCode(arr_item_color[i]);			// item_color
			mi.setSizeCode(arr_item_size[i]);			// item_size
			mi.setStatus("3000");						// 고정값
			
			itemList.add(mi);
		}
		
		ManageItem mi = new ManageItem();
		mi.setItemList(itemList);
		mi.run();
	}
}

