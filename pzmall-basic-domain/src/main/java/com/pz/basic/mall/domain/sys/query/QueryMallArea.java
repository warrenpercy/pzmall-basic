package com.pz.basic.mall.domain.sys.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/8/28 15:31
 */
public class QueryMallArea extends PaginateBaseDO {

    /**主键**/
    private Long id;

    /**区域ID**/
    private String areaId;

    /**区域名称**/
    private String areaName;

    /**城市ID**/
    private String cityId;

    /**状态**/
    private Integer status;

    /**创建人**/
    private String createUser;

    /**修改人**/
    private String modifyUser;

    /**创建时间**/
    private Date created;

    /**修改时间**/
    private Date modified;

    /**支持区域名称模糊查询**/
    private String areaNameLike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

    public String getAreaNameLike() {
        return areaNameLike;
    }

    public void setAreaNameLike(String areaNameLike) {
        this.areaNameLike = areaNameLike;
    }
}
