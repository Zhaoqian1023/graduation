package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Order implements Serializable{
    private String orderId;

    private String deliverUnit;

    private String deliverNum;

    private Integer priceNow;

    private String productModel;

    private Double productCount;

    private Integer deliverPrice;

    private Integer salePrice;

    private Integer realMoney;

    private String status;

    private Date orderTime;

    private Date payTime;

    private Date deliverTime;

    private Date finishTime;

    private String remark;

    private String productId;

    private String storeId;

    private String userId;

    private Integer receiverId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getDeliverUnit() {
        return deliverUnit;
    }

    public void setDeliverUnit(String deliverUnit) {
        this.deliverUnit = deliverUnit == null ? null : deliverUnit.trim();
    }

    public String getDeliverNum() {
        return deliverNum;
    }

    public void setDeliverNum(String deliverNum) {
        this.deliverNum = deliverNum == null ? null : deliverNum.trim();
    }

    public Integer getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(Integer priceNow) {
        this.priceNow = priceNow;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
    }

    public Integer getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(Integer deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(Integer realMoney) {
        this.realMoney = realMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }
}