package com.pz.basic.mall.dao.product.fncategory;

import com.pz.basic.mall.domain.product.fncategory.MallFnCategoryBillboard;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategoryBillboard;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:13
 */
public interface MallFnCategoryBillboardDao {

    long countByQuery(QueryMallFnCategoryBillboard query);

    int deleteMallFnCategoryBillboardByQuery(QueryMallFnCategoryBillboard query);

    int deleteMallFnCategoryBillboardById(long id);

    long insertMallFnCategoryBillboard(MallFnCategoryBillboard record);

    long insertMallFnCategoryBillboardModified(MallFnCategoryBillboard record);

    List<MallFnCategoryBillboard> selectMallFnCategoryBillboardByQuery(QueryMallFnCategoryBillboard query);

    List<MallFnCategoryBillboard> selectMallFnCategoryBillboardByPage(QueryMallFnCategoryBillboard query);

    MallFnCategoryBillboard selectMallFnCategoryBillboardById(long id);

    int updateMallFnCategoryBillboardByIdModified(MallFnCategoryBillboard record);


}
