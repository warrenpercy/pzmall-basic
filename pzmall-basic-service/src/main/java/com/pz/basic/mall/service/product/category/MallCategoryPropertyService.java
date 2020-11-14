package com.pz.basic.mall.service.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategoryProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;
import com.pz.basic.mall.domain.product.property.vo.MallCategoryPropertyVo;
import com.pz.basic.mall.domain.product.property.vo.MallGroupVo;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryProperty;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/19 15:01
 */
public interface MallCategoryPropertyService {
    Result<List<MallGroupVo>> getMallPropertyGroup(QueryMallProperty queryMallProperty);

    Result<List<MallCategoryProperty>> addMallCategoryPropertyBatch(List<MallCategoryProperty> mallCategoryPropertyList);

    Result updateMallCategoryPropertyById(MallCategoryProperty mallCategoryProperty);

    Result<List<MallCategoryProperty>> getMallCategoryPropertysByPage(QueryMallCategoryProperty queryMallCategoryProperty);

    Result<List<MallCategoryPropertyVo>> findForReleaseProduct(QueryMallCategoryProperty queryMallCategoryProperty);
}
