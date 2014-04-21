package com.isec.sc.api.omp;



public class OrderLine {

    private String action;
    private String orderLineKey;




    private String itemId;	        // 상품ID
	private double quantity;        // 구매수량
    private double unitPrice;       // 단가
    private double listPrice;       // 원가
    private double retailPrice;     // 소비자가
    private String reqDeliveryDate; // 배송요청일자
    private String reqShipDate;     // 출하요청일자
    private String shipNode;        // 출하노드


    // getter/setter
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}


    public String getReqDeliveryDate() {
        return reqDeliveryDate;
    }

    public void setReqDeliveryDate(String reqDeliveryDate) {
        this.reqDeliveryDate = reqDeliveryDate;
    }

    public String getReqShipDate() {
        return reqShipDate;
    }

    public void setReqShipDate(String reqShipDate) {
        this.reqShipDate = reqShipDate;
    }

    public String getShipNode() {
        return shipNode;
    }

    public void setShipNode(String shipNode) {
        this.shipNode = shipNode;
    }


    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOrderLineKey() {
        return orderLineKey;
    }

    public void setOrderLineKey(String orderLineKey) {
        this.orderLineKey = orderLineKey;
    }
}
