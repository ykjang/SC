package com.isec.sc.api.omp;



public class OrderLine {


    private String itemId;	   // 상품ID
	private double quantity;   // 구매수량
    private double price;      // 판매가격

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
