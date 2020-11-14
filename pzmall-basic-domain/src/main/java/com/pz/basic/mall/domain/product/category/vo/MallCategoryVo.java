package com.pz.basic.mall.domain.product.category.vo;

import com.pz.basic.mall.domain.base.BaseDO;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 15:20
 */
public class MallCategoryVo extends BaseDO {
    private Long categoryId;
    private String categoryName;
    private Integer level;
    private List<MallCategoryVo> children;

    public List<MallCategoryVo> getChildren() {
        return children;
    }

    public void setChildren(List<MallCategoryVo> children) {
        this.children = children;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
