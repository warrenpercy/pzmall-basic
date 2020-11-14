package com.pz.basic.mall.service.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyGroup;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 8:06
 */
public interface MallPropertyGroupService {
    Result<MallPropertyGroup> addMallPropertyGroup(MallPropertyGroup mallPropertyGroup);

    Result<MallPropertyGroup> getMallPropertyGroupById(long id);

    Result updateMallPropertyGroupById(MallPropertyGroup mallPropertyGroup);

    Result<List<MallPropertyGroup>> getMallPropertyGroupByPage(QueryMallPropertyGroup queryMallPropertyGroup);

    Result<List<MallPropertyGroup>> getMallPropertyGroupsByQuery(QueryMallPropertyGroup queryMallPropertyGroup);
}
