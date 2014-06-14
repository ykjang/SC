package com.isec.sc.api.exec;

import com.isec.sc.api.omp.ChangeOrder;
import com.isec.sc.api.omp.CreateOrder;
import com.isec.sc.api.omp.Order;
import com.isec.sc.api.omp.OrderLine;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CallAPIChangeOrder {

	/**
	 * @param args
	 * @throws java.io.UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		

		Order ord = new Order();

        // OrderHeaderKey
        // 20140421025543388652
        // ord.setOrderHeaderKey("20140421025543388652");

        ord.setEnterpriseCode("Aurora-Corp");
        ord.setSellerOrganizationCode("Aurora");
        ord.setOrderNo("ORDER_TEST_11");

        /*
            결재승인상태 변경 (승인완료)
            AWAIT_AUTH - 승인대기
            AUTHORIZED - 승인
            HOLD - 보류
        */
        ord.setPaymentStatus("AUTHORIZED");

        // 구매자/배송처 정보
        ord.setFirstName("Barackaaa");
        ord.setLastName("Obamabbb");
        ord.setPhone("82212345678");
        ord.setEmail("test@test.com");
        ord.setMobilePhone("1048110813");
        ord.setAddress1("Washington DC");
        ord.setAddress2("ABC Street 1234");
        ord.setCity("Seoul");
        ord.setCountry("KR");
        ord.setZipcode("12345");


        // 주문상품정보 변경(n건, 상품코드,주문수량,가격)
//        ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
//        OrderLine orderLine = new OrderLine();
//
//        orderLine.setAction("Modify");
//        orderLine.setOrderLineKey("20140421025543388653");  // OrderLine Unique key
//        orderLine.setItemId("ITEM0001");
//
//        orderLine.setQuantity(16);
//        orderLine.setUnitPrice(600);
//        orderLine.setListPrice(1000);
//        orderLine.setRetailPrice(1500);
//
//        orderLineList.add(orderLine);
//
//        ord.setOrderLineList(orderLineList);

        ChangeOrder co = new ChangeOrder();
        co.setOrder(ord);
        co.run();
	}
}

