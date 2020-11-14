package com.pz.basic.mall.domain.product.property.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 9:24
 */
public class QueryMallProperty extends PaginateBaseDO {
    private Long propertyId;
    private String propertyName;
    private Long groupId;
    private String features;
    private Integer sortOrder;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    private Long catOneId;
    private Long catTwoId;
    private Long catThreeId;

    private List<Long> groupIdList;

    public List<Long> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Long> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public Long getCatOneId() {
        return catOneId;
    }

    public void setCatOneId(Long catOneId) {
        this.catOneId = catOneId;
    }

    public Long getCatTwoId() {
        return catTwoId;
    }

    public void setCatTwoId(Long catTwoId) {
        this.catTwoId = catTwoId;
    }

    public Long getCatThreeId() {
        return catThreeId;
    }

    public void setCatThreeId(Long catThreeId) {
        this.catThreeId = catThreeId;
    }

    public String getPropertyNameLike() {
        return propertyNameLike;
    }

    public void setPropertyNameLike(String propertyNameLike) {
        this.propertyNameLike = propertyNameLike;
    }

    private String propertyNameLike;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
