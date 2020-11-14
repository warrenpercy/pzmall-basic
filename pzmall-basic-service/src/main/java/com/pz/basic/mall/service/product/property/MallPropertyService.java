package com.pz.basic.mall.service.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 9:16
 */
public interface MallPropertyService {
    Result<MallProperty> addMallProperty(MallProperty mallProperty);

    Result updateMallPropertyById(MallProperty mallProperty);

    Result<List<MallProperty>> getMallPropertysByPage(QueryMallProperty queryMallProperty);
}
