package com.pz.basic.mall.service.freight;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.freight.MallLogistics;
import com.pz.basic.mall.domain.freight.query.QueryMallLogistics;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 16:33
 */
public interface MallLogisticsService {
    Result updateMallLogisticsById(MallLogistics mallLogistics);

    Result<MallLogistics> addMallLogistics(MallLogistics mallLogistics);

    Result<List<MallLogistics>> getMallLogisticssByPage(QueryMallLogistics queryMallLogistics);
}
