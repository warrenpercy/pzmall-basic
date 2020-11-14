package com.pz.basic.mall.service.product.property.impl;

import com.pz.basic.mall.dao.product.property.MallPropertyGroupDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyGroup;
import com.pz.basic.mall.service.product.property.MallPropertyGroupService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 8:08
 */
public class MallPropertyGroupServiceImpl implements MallPropertyGroupService {
    private MallPropertyGroupDao mallPropertyGroupDao;

    public void setMallPropertyGroupDao(MallPropertyGroupDao mallPropertyGroupDao) {
        this.mallPropertyGroupDao = mallPropertyGroupDao;
    }
    @Override
    public Result<MallPropertyGroup> addMallPropertyGroup(MallPropertyGroup mallPropertyGroup) {
        Result<MallPropertyGroup> result = new Result<MallPropertyGroup>();
        try {
            QueryMallPropertyGroup query = new QueryMallPropertyGroup();
            query.setGroupName(mallPropertyGroup.getGroupName());
            long count = mallPropertyGroupDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallPropertyGroup.getGroupName() + "属性组已经存在");
                return result;
            }
            mallPropertyGroup.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallPropertyGroupDao.insertMallPropertyGroup(mallPropertyGroup);
            result.addDefaultModel(mallPropertyGroup);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<MallPropertyGroup> getMallPropertyGroupById(long id) {
        Result<MallPropertyGroup> result = new Result<MallPropertyGroup>();
        try {
            result.addDefaultModel("MallPropertyGroup", mallPropertyGroupDao.selectMallPropertyGroupById(id));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallPropertyGroupById(MallPropertyGroup mallPropertyGroup) {
        Result result = new Result();
        try {
            int count = mallPropertyGroupDao.updateMallPropertyGroupByIdModified(mallPropertyGroup);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallPropertyGroup>> getMallPropertyGroupByPage(QueryMallPropertyGroup queryMallPropertyGroup) {
        Result<List<MallPropertyGroup>> result = new Result<List<MallPropertyGroup>>();
        queryMallPropertyGroup.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallPropertyGroupDao.countByQuery(queryMallPropertyGroup);
        queryMallPropertyGroup.setTotalItem(totalItem);
        queryMallPropertyGroup.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallPropertyGroupDao.selectMallPropertyGroupByPage(queryMallPropertyGroup));
        } else {
            result.addDefaultModel(new ArrayList<MallPropertyGroup>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallPropertyGroup.getPageSize());
        result.setPage(queryMallPropertyGroup.getPage());
        return result;
    }

    @Override
    public Result<List<MallPropertyGroup>> getMallPropertyGroupsByQuery(QueryMallPropertyGroup queryMallPropertyGroup) {
        Result<List<MallPropertyGroup>> result = new Result<List<MallPropertyGroup>>();
        try {
            queryMallPropertyGroup.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            result.addDefaultModel("MallPropertyGroups", mallPropertyGroupDao.selectMallProperytGroupByQuery(queryMallPropertyGroup));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
}
