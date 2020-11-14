package com.pz.basic.mall.domain.freight.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author percy
 * @date 2020/9/24 8:14
 */
public class QueryMallFreightTemplete extends PaginateBaseDO {
    private Long templeteId;
    private String templeteName;
    private String logisticsCode;
    private String logisticsName;
    private Integer templeteType;
    private Integer serviceType;
    private Integer freightType;
    private Integer chargeType;
    private Integer numMin;
    private Integer numMax;
    private BigDecimal firstNumPrice;
    private BigDecimal nextNumPrice;
    private Integer weightMin;
    private Integer weightMax;
    private BigDecimal firstWeightPrice;
    private BigDecimal nextWeightPrice;
    private Integer volumeMin;
    private Integer volumeMax;
    private BigDecimal firstVolumePrice;
    private BigDecimal nextVolumePrice;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    public Long getTempleteId() {
        return templeteId;
    }

    public void setTempleteId(Long templeteId) {
        this.templeteId = templeteId;
    }

    public String getTempleteName() {
        return templeteName;
    }

    public void setTempleteName(String templeteName) {
        this.templeteName = templeteName;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public Integer getTempleteType() {
        return templeteType;
    }

    public void setTempleteType(Integer templeteType) {
        this.templeteType = templeteType;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getFreightType() {
        return freightType;
    }

    public void setFreightType(Integer freightType) {
        this.freightType = freightType;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getNumMin() {
        return numMin;
    }

    public void setNumMin(Integer numMin) {
        this.numMin = numMin;
    }

    public Integer getNumMax() {
        return numMax;
    }

    public void setNumMax(Integer numMax) {
        this.numMax = numMax;
    }

    public BigDecimal getFirstNumPrice() {
        return firstNumPrice;
    }

    public void setFirstNumPrice(BigDecimal firstNumPrice) {
        this.firstNumPrice = firstNumPrice;
    }

    public BigDecimal getNextNumPrice() {
        return nextNumPrice;
    }

    public void setNextNumPrice(BigDecimal nextNumPrice) {
        this.nextNumPrice = nextNumPrice;
    }

    public Integer getWeightMin() {
        return weightMin;
    }

    public void setWeightMin(Integer weightMin) {
        this.weightMin = weightMin;
    }

    public Integer getWeightMax() {
        return weightMax;
    }

    public void setWeightMax(Integer weightMax) {
        this.weightMax = weightMax;
    }

    public BigDecimal getFirstWeightPrice() {
        return firstWeightPrice;
    }

    public void setFirstWeightPrice(BigDecimal firstWeightPrice) {
        this.firstWeightPrice = firstWeightPrice;
    }

    public BigDecimal getNextWeightPrice() {
        return nextWeightPrice;
    }

    public void setNextWeightPrice(BigDecimal nextWeightPrice) {
        this.nextWeightPrice = nextWeightPrice;
    }

    public Integer getVolumeMin() {
        return volumeMin;
    }

    public void setVolumeMin(Integer volumeMin) {
        this.volumeMin = volumeMin;
    }

    public Integer getVolumeMax() {
        return volumeMax;
    }

    public void setVolumeMax(Integer volumeMax) {
        this.volumeMax = volumeMax;
    }

    public BigDecimal getFirstVolumePrice() {
        return firstVolumePrice;
    }

    public void setFirstVolumePrice(BigDecimal firstVolumePrice) {
        this.firstVolumePrice = firstVolumePrice;
    }

    public BigDecimal getNextVolumePrice() {
        return nextVolumePrice;
    }

    public void setNextVolumePrice(BigDecimal nextVolumePrice) {
        this.nextVolumePrice = nextVolumePrice;
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
