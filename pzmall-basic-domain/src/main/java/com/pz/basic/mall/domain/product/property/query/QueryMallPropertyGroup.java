package com.pz.basic.mall.domain.product.property.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/9/2 8:28
 */
public class QueryMallPropertyGroup extends PaginateBaseDO{
    private Long groupId;
    private String groupName;
    private Integer groupType;
    private String features;
    private Integer sortOrder;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;
    /**支持属性组名称模糊查询**/
    private String groupNameLike;

    public String getGroupNameLike() {
        return groupNameLike;
    }

    public void setGroupNameLike(String groupNameLike) {
        this.groupNameLike = groupNameLike;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
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
