package com.pz.basic.mall.service.product.property.impl;

import com.pz.basic.mall.dao.product.property.MallPropertyValueDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.property.MallPropertyValue;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyValue;
import com.pz.basic.mall.service.product.property.MallPropertyValueService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:24
 */
public class MallPropertyValueServiceImpl implements MallPropertyValueService {
    private MallPropertyValueDao mallPropertyValueDao;

    public void setMallPropertyValueDao(MallPropertyValueDao mallPropertyValueDao) {
        this.mallPropertyValueDao = mallPropertyValueDao;
    }

    @Override
    public Result<MallPropertyValue> addMallPropertyValue(MallPropertyValue mallPropertyValue) {
        Result<MallPropertyValue> result = new Result<MallPropertyValue>();
        try {
            QueryMallPropertyValue query = new QueryMallPropertyValue();
            query.setPropertyId(mallPropertyValue.getPropertyId());
            query.setValueData(mallPropertyValue.getValueData());
            long count = mallPropertyValueDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage("属性值已经存在");
                return result;
            }
            mallPropertyValue.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallPropertyValueDao.insertMallPropertyValue(mallPropertyValue);
            result.addDefaultModel(mallPropertyValue);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallPropertyValueById(MallPropertyValue mallPropertyValue) {
        Result result = new Result();
        try {
            int count = mallPropertyValueDao.updateMallPropertyValueByIdModified(mallPropertyValue);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallPropertyValue>> getMallPropertyValuesByPage(QueryMallPropertyValue queryMallPropertyValue) {
        Result<List<MallPropertyValue>> result = new Result<List<MallPropertyValue>>();
        queryMallPropertyValue.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallPropertyValueDao.countByQuery(queryMallPropertyValue);
        queryMallPropertyValue.setTotalItem(totalItem);
        queryMallPropertyValue.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallPropertyValueDao.selectMallPropertyValueByPage(queryMallPropertyValue));
        } else {
            result.addDefaultModel(new ArrayList<MallPropertyValue>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallPropertyValue.getPageSize());
        result.setPage(queryMallPropertyValue.getPage());
        return result;
    }

    @Override
    public Result deleteMallPropertyValueById(Long propertyValueId) {
        Result result = new Result();
        try {
            int count = 0;
            MallPropertyValue modifiedMPV = new MallPropertyValue();
            modifiedMPV.setPropertyValueId(propertyValueId);
            modifiedMPV.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            count = mallPropertyValueDao.updateMallPropertyValueByIdModified(modifiedMPV);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
}
