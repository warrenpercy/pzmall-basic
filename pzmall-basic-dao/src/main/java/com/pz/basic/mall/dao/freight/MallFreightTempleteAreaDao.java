package com.pz.basic.mall.dao.freight;

import com.pz.basic.mall.domain.freight.MallFreightTempleteArea;
import com.pz.basic.mall.domain.freight.query.QueryMallFreightTemplete;
import com.pz.basic.mall.domain.freight.query.QueryMallFreightTempleteArea;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/24 8:21
 */
public interface MallFreightTempleteAreaDao {
    List<MallFreightTempleteArea> selectMallFreightTempleteAreaByQuery(QueryMallFreightTempleteArea query);

    List<MallFreightTempleteArea> selectMallFreightTempleteAreaByPage(QueryMallFreightTempleteArea query);

    int selectMallFreightTempleteAreaById(long id);

    int deleteMallFreightTempleteAreaById(long id);

    int deleteMallFreightTempleteAreaByQuery(QueryMallFreightTempleteArea query);

    long insertMallFreightTempleteArea(MallFreightTempleteArea record);

    long insertMallFreightTempleteAreaModified(MallFreightTempleteArea record);

    long countByQuery(QueryMallFreightTempleteArea query);

    int updateMallFreightTempleteAreaByIdModified(MallFreightTempleteArea record);
}
