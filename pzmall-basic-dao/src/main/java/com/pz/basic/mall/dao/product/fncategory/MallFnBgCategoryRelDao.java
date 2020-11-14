package com.pz.basic.mall.dao.product.fncategory;

import com.pz.basic.mall.domain.product.fncategory.MallFnBgCategoryRel;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnBgCategoryRel;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 15:38
 */
public interface MallFnBgCategoryRelDao {
    List<MallFnBgCategoryRel> selectMallFnBgCategoryRelByQuery(QueryMallFnBgCategoryRel query);

    long insertMallFnBgCategoryRelModified(MallFnBgCategoryRel record);

    long insertMallFnBgCategoryRel(MallFnBgCategoryRel record);

    int updateMallFnBgCategoryRelByIdModified(MallFnBgCategoryRel record);

    long countByQuery(QueryMallFnBgCategoryRel query);

    int deleteMallFnBgCategoryRelByQuery(QueryMallFnBgCategoryRel query);

    int deleteMallFnBgCategoryRelById(long id);

    List<MallFnBgCategoryRel> selectMallFnBgCategoryRelByPage(QueryMallFnBgCategoryRel query);

    MallFnBgCategoryRel selectMallFnBgCategoryRelById(long id);

}
