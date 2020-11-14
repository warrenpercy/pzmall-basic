package com.pz.basic.mall.domain.base.enums;

/**
 * @author percy
 * @date 2020/8/22 14:11
 */
public enum DataStatusEnum {
    STATUS_ENABLE(1, "可用"), STATUS_DISABLE(0, "不可用"), STATUS_DELETED(-1, "删除");

    private int statusValue;
    private String statusInfo;

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

    DataStatusEnum(int statusValue, String statusInfo) {
        this.statusValue = statusValue;
        this.statusInfo = statusInfo;
    }
}
