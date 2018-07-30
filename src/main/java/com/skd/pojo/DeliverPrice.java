package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeliverPrice implements Serializable {
    private Integer id;

    private String deliverUnit;

    private Integer extraPrice;

    private Integer normalPrice;
    
    private String store;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliverUnit() {
        return deliverUnit;
    }

    public void setDeliverUnit(String deliverUnit) {
        this.deliverUnit = deliverUnit == null ? null : deliverUnit.trim();
    }

    public Integer getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(Integer extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Integer getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(Integer normalPrice) {
        this.normalPrice = normalPrice;
    }
    

    public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store == null ? null : store.trim();
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}