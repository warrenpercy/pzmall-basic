package com.pz.basic.mall.service.product.fncategory;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.fncategory.MallFnBgCategoryRel;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnBgCategoryRel;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 15:25
 */
public interface MallFnBgCategoryRelService {
    Result<List<MallFnBgCategoryRel>> getMallFnBgCategoryRelsByQueryWithCateName(QueryMallFnBgCategoryRel queryMallFnBgCategoryRel);

    Result<List<MallFnBgCategoryRel>> addMallFnBgCategoryRelBatch(List<MallFnBgCategoryRel> mallFnBgCategoryRelList);
}
