package com.pz.basic.mall.domain.freight;

import com.pz.basic.mall.domain.base.BaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/9/21 16:53
 */
public class MallLogistics extends BaseDO {
    private Long id;
    private Long logisticsCode;
    private String logisticsName;
    private String logisticsIcon;
    private String logisticsUrl;
    private String logisticsRemark;
    private Integer freightLimit;
    private Integer customFeeLimit;
    private Integer customTimeLimit;
    private Integer showLimit;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(Long logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsIcon() {
        return logisticsIcon;
    }

    public void setLogisticsIcon(String logisticsIcon) {
        this.logisticsIcon = logisticsIcon;
    }

    public String getLogisticsUrl() {
        return logisticsUrl;
    }

    public void setLogisticsUrl(String logisticsUrl) {
        this.logisticsUrl = logisticsUrl;
    }

    public String getLogisticsRemark() {
        return logisticsRemark;
    }

    public void setLogisticsRemark(String logisticsRemark) {
        this.logisticsRemark = logisticsRemark;
    }

    public Integer getFreightLimit() {
        return freightLimit;
    }

    public void setFreightLimit(Integer freightLimit) {
        this.freightLimit = freightLimit;
    }

    public Integer getCustomFeeLimit() {
        return customFeeLimit;
    }

    public void setCustomFeeLimit(Integer customFeeLimit) {
        this.customFeeLimit = customFeeLimit;
    }

    public Integer getCustomTimeLimit() {
        return customTimeLimit;
    }

    public void setCustomTimeLimit(Integer customTimeLimit) {
        this.customTimeLimit = customTimeLimit;
    }

    public Integer getShowLimit() {
        return showLimit;
    }

    public void setShowLimit(Integer showLimit) {
        this.showLimit = showLimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
