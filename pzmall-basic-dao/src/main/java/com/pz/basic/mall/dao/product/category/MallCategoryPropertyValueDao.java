package com.pz.basic.mall.dao.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategoryPropertyValue;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryPropertyValue;

import java.util.List;

/**
 * @author percy
 * @date 2020/10/6 10:14
 */
public interface MallCategoryPropertyValueDao {
    List<MallCategoryPropertyValue> selectMallCategoryPropertyValueByQuery(QueryMallCategoryPropertyValue query);

    List<MallCategoryPropertyValue> selectMallCategoryPropertyValueByPage(QueryMallCategoryPropertyValue query);

    MallCategoryPropertyValue selectMallCategoryPropertyValueById(Long id);

    int deleteMallCategoryPropertyValueById(Long id);

    int deleteMallCategoryPropertyValueByQuery(QueryMallCategoryPropertyValue query);

    long insertMallCategoryPropertyValue(MallCategoryPropertyValue record);

    long insertMallCategoryPropertyValueModified(MallCategoryPropertyValue record);

    long countByQuery(QueryMallCategoryPropertyValue query);

    int updateMallCategoryPropertyValueByIdModified(MallCategoryPropertyValue record);
}
