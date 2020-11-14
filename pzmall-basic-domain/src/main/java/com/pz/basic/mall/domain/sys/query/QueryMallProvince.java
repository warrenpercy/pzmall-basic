package com.pz.basic.mall.domain.sys.query;

import com.pz.basic.mall.domain.base.PaginateBaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/8/28 15:30
 */
public class QueryMallProvince extends PaginateBaseDO{

    /**唯一ID**/
    private Long id;

    /**省份ID**/
    private String provinceId;

    /**省份名称**/
    private String provinceName;

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

    /**支持省份名称模糊查询**/
    private String provinceNameLike;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
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

    public String getProvinceNameLike() {
        return provinceNameLike;
    }

    public void setProvinceNameLike(String provinceNameLike) {
        this.provinceNameLike = provinceNameLike;
    }
}
