package com.isec.sc.api.exec;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.isec.sc.api.cm.ManageItem;
import com.isec.sc.api.core.util.FileContentReader;
import com.isec.sc.api.inv.AdjustInventory;
import com.isec.sc.api.inv.GetInventorySupply;
import com.isec.sc.api.omp.CreateOrder;
import com.isec.sc.api.omp.GetOrderStatus;

public class CallAPIAdInv {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		/* 
		 * Cube -> SC 재고정보 연동(등록,수정)
		 * 
		 * 1. 동기화할 상품정보 조회 (DB, File)
		 * 2. ManageItem객체형 ArrayList로 저장
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
		String rtnXml = ai.invoke();
		
		System.out.println("========== Retrun Message ==========");
		System.out.println(rtnXml);
		
	}
}

