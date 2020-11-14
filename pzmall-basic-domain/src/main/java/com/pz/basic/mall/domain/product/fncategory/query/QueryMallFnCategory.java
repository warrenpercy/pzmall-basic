package com.pz.basic.mall.domain.product.fncategory.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/9/20 9:15
 */
public class QueryMallFnCategory extends PaginateBaseDO {
    private Long fnCategoryId;
    private Long parentId;
    private String fnCategoryName;
    private String fnCategoryImage;
    private Integer level;
    private String seoTitle;
    private String conditions;
    private String seoDescription;
    private String properties;
    private Long brandId;
    private String notes;
    private String features;
    private Integer sortOrder;
    private Integer status;
    private Integer special;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    private String fnCategoryNameLike;

    public Long getFnCategoryId() {
        return fnCategoryId;
    }

    public void setFnCategoryId(Long fnCategoryId) {
        this.fnCategoryId = fnCategoryId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFnCategoryName() {
        return fnCategoryName;
    }

    public void setFnCategoryName(String fnCategoryName) {
        this.fnCategoryName = fnCategoryName;
    }

    public String getFnCategoryImage() {
        return fnCategoryImage;
    }

    public void setFnCategoryImage(String fnCategoryImage) {
        this.fnCategoryImage = fnCategoryImage;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Integer getSpecial() {
        return special;
    }

    public void setSpecial(Integer special) {
        this.special = special;
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

    public String getFnCategoryNameLike() {
        return fnCategoryNameLike;
    }

    public void setFnCategoryNameLike(String fnCategoryNameLike) {
        this.fnCategoryNameLike = fnCategoryNameLike;
    }
}
