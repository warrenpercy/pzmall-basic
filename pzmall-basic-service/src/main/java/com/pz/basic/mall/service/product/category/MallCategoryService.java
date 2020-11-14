package com.pz.basic.mall.service.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategory;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;
import com.pz.basic.mall.domain.product.category.vo.MallCategoryVo;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/18 7:39
 */
public interface MallCategoryService {
    Result<MallCategory> addMallCategory(MallCategory mallCategory);

    Result updateMallCategoryById(MallCategory mallCategory);

    Result<List<MallCategory>> getMallCategorysByPage(QueryMallCategory queryMallCategory);

    Result<List<MallCategory>> getMallCategorysByQuery(QueryMallCategory queryMallCategory);

    Result<List<MallCategoryVo>> getMallCategoryVoList(QueryMallCategory queryMallCategory, List<Long> exculdeIdlist);
}
