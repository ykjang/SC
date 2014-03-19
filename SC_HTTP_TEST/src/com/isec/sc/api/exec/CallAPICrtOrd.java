package com.isec.sc.api.exec;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.isec.sc.api.cm.ManageItem;
import com.isec.sc.api.core.util.FileContentReader;
import com.isec.sc.api.inv.GetInventorySupply;
import com.isec.sc.api.omp.CreateOrder;
import com.isec.sc.api.omp.GetOrderStatus;

public class CallAPICrtOrd {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// Order 생성
		CreateOrder co = new CreateOrder();
		
		co.setPersonName("Barack Obama");
		co.setAddress("Washington DC");
		co.setItem("GRA122A010BLML");
		co.setQuantity(2);
		co.setOrderNo("ORDER_TEST_3");
		co.run();
	}
}

