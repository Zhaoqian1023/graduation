package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
    private String pid;

    private String prouctName;

    private Integer priceNow;

    private Integer priceBefore;

    private String productModel;

    private String productUnit;

    private Double storage;

    private Integer status;

    private String remark;

    private Integer productType;

    private String storeId;

    private Integer deliverPrice;

    private String description;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getProuctName() {
        return prouctName;
    }

    public void setProuctName(String prouctName) {
        this.prouctName = prouctName == null ? null : prouctName.trim();
    }

    public Integer getPriceNow() {
        return priceNow;
    }

    public void setPriceNow(Integer priceNow) {
        this.priceNow = priceNow;
    }

    public Integer getPriceBefore() {
        return priceBefore;
    }

    public void setPriceBefore(Integer priceBefore) {
        this.priceBefore = priceBefore;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public Double getStorage() {
        return storage;
    }

    public void setStorage(Double storage) {
        this.storage = storage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId == null ? null : storeId.trim();
    }

    public Integer getDeliverPrice() {
        return deliverPrice;
    }

    public void setDeliverPrice(Integer deliverPrice) {
        this.deliverPrice = deliverPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}