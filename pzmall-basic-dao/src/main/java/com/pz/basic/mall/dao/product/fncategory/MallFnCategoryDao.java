package com.pz.basic.mall.dao.product.fncategory;

import com.pz.basic.mall.domain.product.fncategory.MallFnCategory;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategory;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:13
 */
public interface MallFnCategoryDao {
    List<MallFnCategory> selectMallFnCategoryByQuery(QueryMallFnCategory query);

    List<MallFnCategory> selectMallFnCategoryByPage(QueryMallFnCategory query);

    MallFnCategory selectMallFnCategoryById(long id);

    int deleteMallFnCategoryById(long id);

    int deleteMallFnCategoryByQuery(QueryMallFnCategory query);

    long insertMallFnCategory(MallFnCategory record);

    long insertMallFnCategoryModified(MallFnCategory record);

    long countByQuery(QueryMallFnCategory query);

    int updateMallFnCategoryByIdModified(MallFnCategory record);
}
