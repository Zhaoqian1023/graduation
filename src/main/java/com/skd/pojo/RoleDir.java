package com.skd.pojo;

public class RoleDir {
    private Integer id;

    private Integer roleid;

    private Integer dirid;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getDirid() {
        return dirid;
    }

    public void setDirid(Integer dirid) {
        this.dirid = dirid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}