package com.pz.basic.mall.domain.freight.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/9/24 8:20
 */
public class QueryMallFreightTempleteArea extends PaginateBaseDO {
    private Long id;
    private Long templeteId;
    private Long privinceId;
    private Long cityId;
    private Long areaId;
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

    public Long getTempleteId() {
        return templeteId;
    }

    public void setTempleteId(Long templeteId) {
        this.templeteId = templeteId;
    }

    public Long getPrivinceId() {
        return privinceId;
    }

    public void setPrivinceId(Long privinceId) {
        this.privinceId = privinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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
