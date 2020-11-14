package com.pz.basic.mall.domain.product.property.vo;

import com.pz.basic.mall.domain.base.BaseDO;

/**
 * @author percy
 * @date 2020/10/6 10:11
 */
public class MallCategoryPropertyValueVo extends BaseDO {
    private Long id;
    private String name;
    private int checked;

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
