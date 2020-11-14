package com.pz.basic.mall.domain.base;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author percy
 * @date 2020-08-21 10:03:44
 */
public class BaseDO implements Serializable {
    private static final long serialVersionUID = -2416627414308017937L;

    /**
     * 如果字段值为null将不包含在toString中
     * @return
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
