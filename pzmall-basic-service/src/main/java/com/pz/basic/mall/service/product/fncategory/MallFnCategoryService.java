package com.pz.basic.mall.service.product.fncategory;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategory;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategory;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:08
 */
public interface MallFnCategoryService {
    Result<MallFnCategory> addMallFnCategory(MallFnCategory mallFnCategory);

    Result<MallFnCategory> getMallFnCategoryById(int id);

    Result updateMallFnCategoryById(MallFnCategory mallFnCategory);

    Result<List<MallFnCategory>> getMallFnCategorysByPage(QueryMallFnCategory queryMallFnCategory);
}
