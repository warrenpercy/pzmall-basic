package com.pz.basic.mall.domain.product.property.vo;

import com.pz.basic.mall.domain.base.BaseDO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/10/6 9:58
 */
public class MallCategoryPropertyVo extends BaseDO {
    private Long id;
    private String name;
    private Integer propertyType;
    private int checked;
    private List<MallCategoryPropertyValueVo> valueList = new ArrayList<MallCategoryPropertyValueVo>();

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public List<MallCategoryPropertyValueVo> getValueList() {
        return valueList;
    }

    public void setValueList(List<MallCategoryPropertyValueVo> valueList) {
        this.valueList = valueList;
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

    public Integer getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }
}
