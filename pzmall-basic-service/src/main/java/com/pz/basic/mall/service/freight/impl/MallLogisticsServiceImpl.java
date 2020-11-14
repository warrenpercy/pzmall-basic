package com.pz.basic.mall.service.freight.impl;

import com.pz.basic.mall.dao.freight.MallLogisticsDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.freight.MallLogistics;
import com.pz.basic.mall.domain.freight.query.QueryMallLogistics;
import com.pz.basic.mall.service.freight.MallLogisticsService;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 16:40
 */
public class MallLogisticsServiceImpl implements MallLogisticsService {
    private MallLogisticsDao mallLogisticsDao;

    public void setMallLogisticsDao(MallLogisticsDao mallLogisticsDao) {
        this.mallLogisticsDao = mallLogisticsDao;
    }

    @Override
    public Result updateMallLogisticsById(MallLogistics mallLogistics) {
        Result result = new Result();
        try {
            int count = mallLogisticsDao.updateMallLogisticsByIdModified(mallLogistics);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<MallLogistics> addMallLogistics(MallLogistics mallLogistics) {
        Result<MallLogistics> result = new Result<MallLogistics>();
        try {
            QueryMallLogistics query = new QueryMallLogistics();
            query.setLogisticsName(mallLogistics.getLogisticsName());
            long count = mallLogisticsDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallLogistics.getLogisticsName() + "承运商已经存在");
                return result;
            }
            mallLogistics.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallLogisticsDao.insertMallLogistics(mallLogistics);
            result.addDefaultModel(mallLogistics);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallLogistics>> getMallLogisticssByPage(QueryMallLogistics queryMallLogistics) {
        Result<List<MallLogistics>> result = new Result<List<MallLogistics>>();
        long totalItem = mallLogisticsDao.countByQuery(queryMallLogistics);
        queryMallLogistics.setTotalItem(totalItem);
        queryMallLogistics.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallLogisticsDao.selectMallLogisticsByPage(queryMallLogistics));
        } else {
            result.addDefaultModel(new ArrayList<MallLogistics>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallLogistics.getPageSize());
        result.setPage(queryMallLogistics.getPage());
        return result;
    }
}
