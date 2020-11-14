package com.pz.basic.mall.domain.sys;

import com.pz.basic.mall.domain.base.BaseDO;

import java.util.Date;

/**
 * @author percy
 * @date 2020/8/21 10:08
 */
public class MallBrand extends BaseDO {
    /**主键**/
    private Long id;

    /**品牌名**/
    private String brandName;

    /**logo图片地址**/
    private String logo;

    /**品牌首字母**/
    private String firstChar;

    /**状态1可用0不可用**/
    private Integer status;

    /**记录状态1有效0删除**/
    private Integer active;

    /**创建人**/
    private String createUser;

    /**修改人**/
    private String modifyUser;

    /**创建时间**/
    private Date created;

    /**修改时间**/
    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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
