package com.pz.basic.mall.service.product.property.impl;

import com.pz.basic.mall.dao.product.property.MallPropertyDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.property.MallProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;
import com.pz.basic.mall.service.product.property.MallPropertyService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 9:17
 */
public class MallPropertyServiceImpl implements MallPropertyService {
    private MallPropertyDao mallPropertyDao;

    public void setMallPropertyDao(MallPropertyDao mallPropertyDao) {
        this.mallPropertyDao = mallPropertyDao;
    }

    @Override
    public Result<MallProperty> addMallProperty(MallProperty mallProperty) {
        Result<MallProperty> result = new Result<MallProperty>();
        try {
            QueryMallProperty query = new QueryMallProperty();
            query.setPropertyName(mallProperty.getPropertyName());
            long count = mallPropertyDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallProperty.getPropertyName() + "属性已经存在");
                return result;
            }
            mallProperty.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallPropertyDao.insertMallProperty(mallProperty);
            result.addDefaultModel(mallProperty);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallPropertyById(MallProperty mallProperty) {
        Result result = new Result();
        try {
            int count = mallPropertyDao.updateMallPropertyByIdModified(mallProperty);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallProperty>> getMallPropertysByPage(QueryMallProperty queryMallProperty) {
        Result<List<MallProperty>> result = new Result<List<MallProperty>>();
        queryMallProperty.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallPropertyDao.countByQuery(queryMallProperty);
        queryMallProperty.setTotalItem(totalItem);
        queryMallProperty.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallPropertyDao.selectMallPropertyByPage(queryMallProperty));
        } else {
            result.addDefaultModel(new ArrayList<MallProperty>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallProperty.getPageSize());
        result.setPage(queryMallProperty.getPage());
        return result;
    }
}
