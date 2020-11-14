package com.pz.basic.mall.dao.product.category;

import com.pz.basic.mall.domain.product.category.MallCategoryProperty;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryProperty;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/19 15:56
 */
public interface MallCategoryPropertyDao {
    List<MallCategoryProperty> selectMallCategoryPropertyByQuery(QueryMallCategoryProperty query);
    int updateMallCategoryPropertyByIdModified(MallCategoryProperty mallCategoryProperty);
    List<MallCategoryProperty> selectMallCategoryPropertyByPage(QueryMallCategoryProperty query);
    long countByQuery(QueryMallCategoryProperty query);
    long insertMallCategoryProperty(MallCategoryProperty mcp);
}
