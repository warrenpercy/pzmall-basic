package com.pz.basic.mall.dao.freight;

import com.pz.basic.mall.domain.freight.MallFreightTemplete;
import com.pz.basic.mall.domain.freight.query.QueryMallFreightTemplete;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/24 8:15
 */
public interface MallFreightTempleteDao {
    List<MallFreightTemplete> selectMallFreightTempleteByQuery(QueryMallFreightTemplete query);

    List<MallFreightTemplete> selectMallFreightTempleteByPage(QueryMallFreightTemplete query);

    MallFreightTemplete selectMallFreightTempleteById(Long id);

    int deleteMallFreightTempleteById(Long id);

    int deleteMallFreightTempleteByQuery(QueryMallFreightTemplete query);

    long insertMallFreightTemplete(MallFreightTemplete record);

    long insertMallFreightTempleteModified(MallFreightTemplete record);

    long countByQuery(QueryMallFreightTemplete query);

    int updateMallFreightTempleteByIdModified(MallFreightTemplete record);
}
