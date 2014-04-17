package com.isec.sc.api.exec;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.isec.sc.api.cm.ManageItem;
import com.isec.sc.api.core.util.FileContentReader;
import com.isec.sc.api.inv.GetInventorySupply;
import com.isec.sc.api.omp.CreateOrder;
import com.isec.sc.api.omp.GetOrderStatus;
import com.isec.sc.api.omp.OrderLine;

public class CallAPICrtOrd {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		

		CreateOrder co = new CreateOrder();

        // Order Master 생성
        co.setEnterpriseCode("Aurora-Corp");
        co.setSellerOrganizationCode("Aurora");
        co.setPaymentStatus("AWAIT_AUTH");
        co.setOrderNo("ORDER_TEST_1");

        // 주문상품정보 생성(상품코드,주문수량,가격)
        ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine();
        orderLine.setItemId("ITEM0001");
        orderLine.setQuantity(3);
        orderLine.setPrice(1500);
        orderLineList.add(orderLine);

        co.setOrderLineList(orderLineList);


        // 구매자 정보
		co.setPersonName("Barack Obama");
		co.setAddress("Washington DC");

        co.run();
	}
}

