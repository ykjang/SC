package com.ibm.swg.sterling.demo.api;

import java.text.MessageFormat;

import com.ibm.klab.util.FileContentReader;
import com.ibm.swg.sterling.demo.SterlingAPIWrapper;

public class CreateOrder {
	private static final String templateFile = "createOrder.template.xml";
	private String personName;
	private String address;
	private String item;
	private double quantity;
	private String orderNo;
	
	public void run() {
		SterlingAPIWrapper api = new SterlingAPIWrapper();
		String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));
		
		MessageFormat msg = new MessageFormat(template);
		//String input = msg.format(new String[] { personName, address, item, Double.toString(quantity), orderNo});
		String input = msg.format(new String[] { personName, address, item, Double.toString(quantity)});
		
		StringBuffer xml = new StringBuffer();
		xml.append("<Order CarrierServiceCode='2 Day' DocumentType='0001'  EnteredBy='yantra' "); 
		xml.append(" DraftOrderFlag='N' EnterpriseCode='DEFAULT' "); 
		xml.append(" OrderType='' ReqCancelDate='' ReqDeliveryDate='' ReqShipDate='' "); 
		xml.append(" SellerOrganizationCode=''  BuyerOrganizationCode='DEFAULT' ShipNode=''  OrderNo='' PaymentRuleId='' PriceProgramName='' SCAC='FEDX'>");
		xml.append("<OrderLines>");
		xml.append("<OrderLine ShipNode='' ReceivingNode='' OrderedQty='3' PrimeLineNo='1' SubLineNo='1'>");
		xml.append("<Item ItemID='Y123'  ProductClass='A' UnitOfMeasure='EACH' />");
		xml.append("</OrderLine>");
		xml.append("</OrderLines>");
		xml.append("<PersonInfoBillTo  City='Camb'  LastName='Test'  />"); 
		xml.append("</Order>");
		
		api.createOrder(xml.toString());
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
