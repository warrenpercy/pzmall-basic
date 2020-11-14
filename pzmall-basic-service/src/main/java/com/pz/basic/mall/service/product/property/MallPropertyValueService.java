package com.pz.basic.mall.service.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallPropertyValue;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyValue;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:20
 */
public interface MallPropertyValueService {
    Result<MallPropertyValue> addMallPropertyValue(MallPropertyValue mallPropertyValue);

    Result updateMallPropertyValueById(MallPropertyValue mallPropertyValue);

    Result<List<MallPropertyValue>> getMallPropertyValuesByPage(QueryMallPropertyValue queryMallPropertyValue);

    Result deleteMallPropertyValueById(Long propertyValueId);
}
