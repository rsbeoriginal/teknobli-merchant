package com.teknobli.merchant.ordermicroservices.dto;


import java.util.Date;
import java.util.List;

public class RecieptDTO {

    private String  userOrderId;
    private String userId;
    private String address;
    private String phoneNo;
    private String emailId;
    private Date orderTimeStamp;

    List<RecieptProductDTO> recieptProductDTOList;


    public String getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(String userOrderId) {
        this.userOrderId = userOrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getOrderTimeStamp() {
        return orderTimeStamp;
    }

    public void setOrderTimeStamp(Date orderTimeStamp) {
        this.orderTimeStamp = orderTimeStamp;
    }

    public List<RecieptProductDTO> getRecieptProductDTOList() {
        return recieptProductDTOList;
    }

    public void setRecieptProductDTOList(List<RecieptProductDTO> recieptProductDTOList) {
        this.recieptProductDTOList = recieptProductDTOList;
    }
}
