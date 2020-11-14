package com.pz.basic.mall.domain.base.enums;

/**
 * @author percy
 * @date 2020/8/22 14:11
 */
public enum DataActiveStatusEnum {

    STATUS_ACTIVE(1, "有效"), STATUS_DELETED(0, "删除");

    private int statusValue;
    private String statusInfo;

    DataActiveStatusEnum(int statusValue, String statusInfo) {
        this.statusValue = statusValue;
        this.statusInfo = statusInfo;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(int statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }
}
