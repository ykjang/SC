/*
 * Created on: Nov 4, 2005
 * Author: voommen
 *
 */
    package com.isec.sc.api.cust;

    import org.w3c.dom.Document;
    import org.w3c.dom.Element;

    import com.yantra.yfs.japi.YFSEnvironment;
    import com.yantra.yfs.japi.YFSUserExitException;
    import com.yantra.yfs.japi.ue.YFSBeforeCreateOrderUE;

    /**
     *
     * Updates the OrderNo based on the OrderType
     */
    public class manageItemUE implements YFSBeforeCreateOrderUE
    {

        public Document beforeCreateOrder(YFSEnvironment env, Document inDoc) throws YFSUserExitException{

            final String NORMAL_ORDER_TYPE = "NORMAL";
            final String NORMAL_ORDER_NO = "N-";
            final String URGENT_ORDER_TYPE = "URGENT";
            final String URGENT_ORDER_NO = "U-";

            Element orderEle = inDoc.getDocumentElement();
            String orderType = orderEle.getAttribute("OrderType");
            String orderNo = orderEle.getAttribute("OrderNo");

            if(orderType != null && !orderType.trim().equalsIgnoreCase("") && orderNo != null && !orderNo.trim().equalsIgnoreCase("")){
                orderType = orderType.trim();
                if(orderType.equalsIgnoreCase(NORMAL_ORDER_TYPE))
                    orderNo = NORMAL_ORDER_NO.concat(orderNo);
                else if(orderType.equalsIgnoreCase(URGENT_ORDER_TYPE))
                    orderNo = URGENT_ORDER_NO.concat(orderNo);
            }

            orderEle.setAttribute("OrderNo",orderNo);

            return inDoc;
        }

        public String beforeCreateOrder(YFSEnvironment env, String inXml){
            return inXml;
        }
    }

