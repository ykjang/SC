package com.ibm.swg.sterling.demo.api;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.ibm.klab.util.FileContentReader;
import com.ibm.swg.sterling.demo.SterlingAPIWrapper;

public class AdjustInventory {
	private static final String templateFile = "adjustInventory.template.xml";
	
	private static final String itemTemplate = "<Item ItemID=\"{0}\" OrganizationCode=\"{1}\" UnitOfMeasure=\"{2}\" "
			+ " ProductClass=\"{3}\" "
			+ " Quantity=\"{4}\" "
			+ " ShipNode=\"{5}\" "
			+ " SupplyType=\"{6}\" "
			+ " AdjustmentType=\"{7}\"> "
			+ "</Item>"; 
	
	
	private String itemID;
	private String organizationCode;
	private String unitOfMeasure;
	private String productClass;
	private Integer quantity;
	private String shipNode;
	private String supplyType;
	private String adjustmentType;
	
	private ArrayList<AdjustInventory> itemList = new ArrayList<AdjustInventory>();
	
	
	public String run() {
		SterlingAPIWrapper api = new SterlingAPIWrapper();
		
		// Item List XML 생성
		MessageFormat itemMsg = new MessageFormat(itemTemplate);
		String allItemText = "";
		for(int i=0; i<itemList.size(); i++){
			
			String[] item_param = {
									itemList.get(i).itemID, itemList.get(i).organizationCode, itemList.get(i).unitOfMeasure,
									itemList.get(i).productClass, Integer.toString(itemList.get(i).quantity), itemList.get(i).shipNode,
									itemList.get(i).supplyType, itemList.get(i).adjustmentType
								  };
			
			String itemInput = itemMsg.format(item_param);
			allItemText += itemInput;
		}		
		
		// Template 파일로드
		String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));		
		
		// 생성된 Item XML 반영
		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[]{allItemText});
		
		//  API 호출
		return api.adjustInventory(input);
	}
	
	
	

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getProductClass() {
		return productClass;
	}

	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public String getShipNode() {
		return shipNode;
	}

	public void setShipNode(String shipNode) {
		this.shipNode = shipNode;
	}

	public String getSupplyType() {
		return supplyType;
	}


	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}

	public String getAdjustmentType() {
		return adjustmentType;
	}

	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	public ArrayList<AdjustInventory> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<AdjustInventory> itemList) {
		this.itemList = itemList;
	}
}
