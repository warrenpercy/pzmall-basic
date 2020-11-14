package com.pz.basic.mall.domain.product.fncategory.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/9/20 9:39
 */
public class QueryMallFnCategoryBillboard extends PaginateBaseDO {
    private Long id;
    private Long fnCategoryId;
    private String imageUrl;
    private Integer type;
    private String redirectArea;
    private String features;
    private Integer status;
    private String createUser;
    private String modifyUser;
    private Date created;
    private Date modified;

    public Long getFnCategoryId() {
        return fnCategoryId;
    }

    public void setFnCategoryId(Long fnCategoryId) {
        this.fnCategoryId = fnCategoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRedirectArea() {
        return redirectArea;
    }

    public void setRedirectArea(String redirectArea) {
        this.redirectArea = redirectArea;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
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

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
