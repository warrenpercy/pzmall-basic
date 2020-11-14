package com.pz.basic.mall.service.freight;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.freight.MallFreightTemplete;
import com.pz.basic.mall.domain.freight.query.QueryMallFreightTemplete;
import com.pz.basic.mall.domain.product.property.vo.AreaSelectedVo;

import java.util.List;

/**
 * @author percy
 * @date 2020/10/6 9:21
 */
public interface MallFreightTempleteService {
    Result updateMallFreightTempleteById(MallFreightTemplete mallFreightTemplete);

    Result<List<MallFreightTemplete>> getMallFreightTempletesByPage(QueryMallFreightTemplete queryMallFreightTemplete);

    Result<MallFreightTemplete> findDefaultlFreightTemplete(QueryMallFreightTemplete queryMallFreightTemplete);

    Result<List<AreaSelectedVo>> selectForFreightTemplete(QueryMallFreightTemplete queryMallFreightTemplete);

    Result<MallFreightTemplete> getMallFreightTempleteById(Long id);

    Result<MallFreightTemplete> addMallFreightTemplete(MallFreightTemplete mallFreightTemplete);
}
