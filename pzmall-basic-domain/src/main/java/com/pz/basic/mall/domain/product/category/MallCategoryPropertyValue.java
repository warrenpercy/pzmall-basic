package com.pz.basic.mall.domain.product.category;

import com.pz.basic.mall.domain.base.BaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/10/6 10:04
 */
public class MallCategoryPropertyValue extends BaseDO {
    private Long categoryPropertyValueId;
    private Long categoryPropertyId;
    private Long categoryId;
    private Long propertyId;
    private Long propertyValueId;
    private String propertyValueData;
    private String features;
    private Integer sortOrder;
    private Integer active;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    public Long getCategoryPropertyValueId() {
        return categoryPropertyValueId;
    }

    public void setCategoryPropertyValueId(Long categoryPropertyValueId) {
        this.categoryPropertyValueId = categoryPropertyValueId;
    }

    public Long getCategoryPropertyId() {
        return categoryPropertyId;
    }

    public void setCategoryPropertyId(Long categoryPropertyId) {
        this.categoryPropertyId = categoryPropertyId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(Long propertyValueId) {
        this.propertyValueId = propertyValueId;
    }

    public String getPropertyValueData() {
        return propertyValueData;
    }

    public void setPropertyValueData(String propertyValueData) {
        this.propertyValueData = propertyValueData;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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
