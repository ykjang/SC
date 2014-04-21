package com.isec.sc.api.omp;

import java.text.MessageFormat;

import com.isec.sc.api.core.SterlingHTTPConnector;
import com.isec.sc.api.core.util.FileContentReader;

public class CreateOrder {

	private static final String apiName = "createOrder"; // API Name

    private static final String templateFile = "createOrder.template.xml"; // API Input Template (Order)
	private static final String ol_templateFile = "createOrderLine.template.xml"; // API Input Template (OrderLine)

	
    private Order order;

    public void setOrder(Order order){
        this.order = order;
    }


    public void run() {


        // OrderLine XML Generation
        String ol_template = FileContentReader.readContent(getClass().getResourceAsStream(ol_templateFile));

        MessageFormat orderLineMsg = new MessageFormat(ol_template);
        String orderLineText = "";
        for(int i=0; i<order.getOrderLineList().size(); i++){

            OrderLine orderLine = order.getOrderLineList().get(i);
            orderLineText += orderLineMsg.format(new String[] { Double.toString(orderLine.getQuantity()),
                                                                orderLine.getItemId(),
                                                                Double.toString(orderLine.getUnitPrice()),
                                                                Double.toString(orderLine.getListPrice()),
                                                                Double.toString(orderLine.getRetailPrice())
            });
        }

        // Order XML Generation
        String template = FileContentReader.readContent(getClass().getResourceAsStream(templateFile));

		MessageFormat msg = new MessageFormat(template);
		String input = msg.format(new String[] { order.getEnterpriseCode(),
                order.getSellerOrganizationCode(),
                order.getPaymentStatus(),
                order.getOrderNo(),
                order.getReqDeliveryDate(),
                order.getShipNode(),
                order.getFirstName(), order.getLastName(), order.getPhone(), order.getEmail(), order.getMobilePhone(),
                order.getAddress1(), order.getAddress2(), order.getCity(), order.getCountry(), order.getZipcode(),
                orderLineText
        });
		
		//  API 호출
		SterlingHTTPConnector sterling = new SterlingHTTPConnector();
		sterling.setApi(apiName);
		sterling.setData(input);

        sterling.run();
		
	}

}
