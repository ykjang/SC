package com.ibm.swg.sterling.demo;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.ibm.klab.util.FileContentReader;
import com.ibm.swg.sterling.demo.api.AdjustInventory;
import com.ibm.swg.sterling.demo.api.CreateOrder;
import com.ibm.swg.sterling.demo.api.GetInventorySupply;
import com.ibm.swg.sterling.demo.api.GetOrderStatus;
import com.ibm.swg.sterling.demo.api.ManageItem;

public class SterlingAPITestAdIvn {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {

		/* 
		 * Cube -> SC 재고정보 연동(등록,수정)
		 * 
		 * 1. 동기화할 상품정보 조회 (DB, File)
		 * 2. ManageItem 객체형 ArrayList로 저장
		 * 3. manageItem API invoke
		 */
		// Sample Data
		String[] arr_bar_code = {"GRA122A010BLML","GRA122A010BLXSS","GRA122A01GORML", "GRA122A01GORXSS"};
		Integer[] arr_stockQty = {100, 100, 100, 100};
		String[] arr_ship_node = {"Matrix_WH1","Matrix_WH1","Matrix_WH1","Matrix_WH1"};
		
		ArrayList<AdjustInventory> itemList = new ArrayList<AdjustInventory>(); 
		for(int i=0; i<arr_bar_code.length; i++){
			
			AdjustInventory obj = new AdjustInventory();
			obj.setItemID(arr_bar_code[i]);
			obj.setOrganizationCode("Matrix");
			obj.setUnitOfMeasure("EACH");
			obj.setProductClass("GOOD");
			obj.setSupplyType("ONHAND");
			obj.setAdjustmentType("ADJUSTMENT");
			obj.setQuantity(arr_stockQty[i]);
			obj.setShipNode(arr_ship_node[i]);
			
			itemList.add(obj);
		}
		
		AdjustInventory ai = new AdjustInventory();
		ai.setItemList(itemList);
		
		// API 호출
		String rtnXml = ai.run();
		
		System.out.println("========== Retrun Message ==========");
		System.out.println(rtnXml);
		
	}
}

