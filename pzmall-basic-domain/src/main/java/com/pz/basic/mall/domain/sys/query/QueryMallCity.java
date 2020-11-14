package com.pz.basic.mall.domain.sys.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/8/28 15:30
 */
public class QueryMallCity extends PaginateBaseDO{

    /**主键**/
    private Long id;

    /**城市ID**/
    private String cityId;

    /**城市名称**/
    private String cityName;

    /**省份ID**/
    private String provinceId;

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

    /**支持城市名称模糊查询**/
    private String cityNameLike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
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

    public String getCityNameLike() {
        return cityNameLike;
    }

    public void setCityNameLike(String cityNameLike) {
        this.cityNameLike = cityNameLike;
    }
}
