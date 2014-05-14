package com.isec.sc.api.exec;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;

import com.isec.sc.api.cm.ManageItem;
import com.isec.sc.api.core.util.FileContentReader;
import com.isec.sc.api.inv.GetInventorySupply;
import com.isec.sc.api.omp.CreateOrder;
import com.isec.sc.api.omp.GetOrderStatus;
import com.isec.sc.api.omp.Order;
import com.isec.sc.api.omp.OrderLine;

public class CallAPICreateOrder {

	/**
	 * @param args
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		

		Order ord = new Order();

        // Order 기본정보
        ord.setEnterpriseCode("Aurora-Corp");
        ord.setOrderNo("ORDER_TEST_17");
        ord.setSellerOrganizationCode("Aurora");
        ord.setBuyerUserId("100000049");
        ord.setPaymentStatus("AWAIT_AUTH");
        ord.setReqDeliveryDate("2014-05-05");
        ord.setReqShipDate("2014-05-01");
        ord.setShipNode("Aurora_WH1");

        // 배송처 정보
        ord.setFirstName("Barack");
        ord.setLastName("Obama");
        ord.setPhone("82212345678");
        ord.setEmail("test@test.com");
        ord.setMobilePhone("1048110813");
        ord.setAddress1("Washington DC");
        ord.setAddress2("ABC Street 1234");
        ord.setCity("Washington");
        ord.setCountry("KR");
        ord.setZipcode("123456");


        // Order 상품정보 생성(n건, 상품코드,주문수량,가격) - 테스트로 2건의 주문상품데이타 생성
        ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine();

        orderLine.setItemId("ITEM0001");
        orderLine.setQuantity(3);
        orderLine.setUnitPrice(500);
        orderLineList.add(orderLine);

//        orderLine = new OrderLine();
//        orderLine.setItemId("ITEM0002");
//        orderLine.setQuantity(5);
//        orderLine.setUnitPrice(700);
//        orderLineList.add(orderLine);
//
        ord.setOrderLineList(orderLineList);

        CreateOrder co = new CreateOrder();
        co.setOrder(ord);
        co.run();
	}
}

