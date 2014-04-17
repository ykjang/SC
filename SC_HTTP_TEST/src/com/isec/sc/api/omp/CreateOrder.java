package com.isec.sc.api.omp;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.isec.sc.api.core.SterlingHTTPConnector;
import com.isec.sc.api.core.util.FileContentReader;

public class CreateOrder {

	private static final String apiName = "createOrder"; // API Name
	private static final String templateFile = "createOrder.template.xml"; // API Input Template
    // OrderLine XML
    private static final String orderLineXML =
                                        "<OrderLine OrderedQty=\"{0}\">\n" +
                                        "    <Item ItemID=\"{1}\" UnitOfMeasure=\"EACH\" ProductClass=\"GOOD\"/>\n" +
                                        "    <LinePriceInfo DiscountPercentage=\"0\" IsLinePriceForInformationOnly=\"N\" IsPriceLocked=\"Y\" " +
                                                "ListPrice=\"{2}\" RetailPrice=\"{2}\" UnitPrice=\"{2}\" />\n" +
                                        "</OrderLine>";
	
	// API Input Attribute
    private String enterpriseCode; // 엔터프라이즈코드
    private String sellerOrganizationCode;  // 판매조직코드
    private String paymentStatus;   // 결제상태
    private String orderNo;    // 주문번호
    private String personName; // 구매자
	private String address;    // 배송지 주소

    // OrderLine 정보 (주문상품, 수량, 가격)
    private ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();


    public void run() {

        MessageFormat orderLineMsg = new MessageFormat(orderLineXML);
        String orderLineText = "";
        for(int i=0; i<orderLineList.size(); i++){

            OrderLine orderLine = orderLineList.get(i);
            orderLineText += orderLineMsg.format(new String[] { Double.toString(orderLine.getQuantity()),
                                                                orderLine.getItemId(),
                                                                Double.toString(orderLine.getPrice()) });
        }

        String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));
		
		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[] { this.enterpriseCode, this.sellerOrganizationCode, this.paymentStatus, orderNo,
                                                 orderLineText, personName, address});
		
		//  API 호출
		SterlingHTTPConnector sterling = new SterlingHTTPConnector();
		sterling.setApi(apiName);
		sterling.setData(input);
		sterling.run();
		
	}
	
	// getter/setter
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getSellerOrganizationCode() {
        return sellerOrganizationCode;
    }

    public void setSellerOrganizationCode(String sellerOrganizationCode) {
        this.sellerOrganizationCode = sellerOrganizationCode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

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


    public ArrayList<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }
}
