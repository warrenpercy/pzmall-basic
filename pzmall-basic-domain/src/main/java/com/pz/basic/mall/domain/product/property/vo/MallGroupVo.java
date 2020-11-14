package com.pz.basic.mall.domain.product.property.vo;

import com.pz.basic.mall.domain.base.BaseDO;
import com.pz.basic.mall.domain.product.property.MallProperty;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/19 14:33
 */
public class MallGroupVo extends BaseDO {
    private Long id;
    private String label;
    private List<MallProperty> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MallProperty> getChildren() {
        return children;
    }

    public void setChildren(List<MallProperty> children) {
        this.children = children;
    }
}
