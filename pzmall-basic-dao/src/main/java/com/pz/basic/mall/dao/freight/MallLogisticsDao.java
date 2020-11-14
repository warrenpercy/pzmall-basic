package com.pz.basic.mall.dao.freight;

import com.pz.basic.mall.domain.freight.MallLogistics;
import com.pz.basic.mall.domain.freight.query.QueryMallLogistics;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 16:58
 */
public interface MallLogisticsDao {
    List<MallLogistics> selectMallLogisticsByQuery(QueryMallLogistics query);

    List<MallLogistics> selectMallLogisticsByPage(QueryMallLogistics query);

    MallLogistics selectMallLogisticsById(long id);

    int deleteMallLogisticsById(long id);

    int deleteMallLogisticsByQuery(QueryMallLogistics query);

    long insertMallLogistics(MallLogistics record);

    long insertMallLogisticsModified(MallLogistics record);

    long countByQuery(QueryMallLogistics query);

    int updateMallLogisticsByIdModified(MallLogistics record);
}
