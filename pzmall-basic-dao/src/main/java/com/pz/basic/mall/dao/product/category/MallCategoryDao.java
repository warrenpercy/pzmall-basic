package com.pz.basic.mall.dao.product.category;

import com.pz.basic.mall.domain.product.category.MallCategory;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/18 8:14
 */
public interface MallCategoryDao {

    List<MallCategory> selectMallCategoryByQuery(QueryMallCategory query);

    MallCategory selcetMallCategoryById(long id);

    int deleteMallCategoryById(long id);

    int deleteMallCategoryByQuery(QueryMallCategory query);

    long insertMallCategory(MallCategory record);

    long insertMallCategoryModified(MallCategory record);

    long countByQuery(QueryMallCategory query);

    int updateMallCategoryByIdModified(MallCategory record);
}
