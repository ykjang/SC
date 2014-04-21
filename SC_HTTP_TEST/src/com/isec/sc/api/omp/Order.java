package com.isec.sc.api.omp;


import java.util.ArrayList;

public class Order {

    private String orderHeaderKey;          // Order Unique Key

    private String enterpriseCode;          // 엔터프라이즈코드
    private String sellerOrganizationCode;  // 판매조직코드
    private String paymentStatus;           // 결제상태
    private String orderNo;                 // 주문번호
    private String reqDeliveryDate;         // 배송요청일자
    private String shipNode;                // 출하노드

    // 구매자/배송처 정보
    private String firstName;
    private String lastName;

    private String phone;
    private String email;
    private String mobilePhone;

    private String address1;
    private String address2;
    private String city;
    private String country;
    private String zipcode;

    // OrderLine 정보 (주문상품, 수량, 가격)
    private ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();


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

    public String getReqDeliveryDate() {
        return reqDeliveryDate;
    }

    public void setReqDeliveryDate(String reqDeliveryDate) {
        this.reqDeliveryDate = reqDeliveryDate;
    }

    public String getShipNode() {
        return shipNode;
    }

    public void setShipNode(String shipNode) {
        this.shipNode = shipNode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public ArrayList<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(ArrayList<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public String getOrderHeaderKey() {
        return orderHeaderKey;
    }

    public void setOrderHeaderKey(String orderHeaderKey) {
        this.orderHeaderKey = orderHeaderKey;
    }
}
