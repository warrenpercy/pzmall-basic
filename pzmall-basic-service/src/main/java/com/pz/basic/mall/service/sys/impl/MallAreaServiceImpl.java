package com.pz.basic.mall.service.sys.impl;

import com.pz.basic.mall.dao.sys.MallAreaDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.sys.MallArea;
import com.pz.basic.mall.domain.sys.query.QueryMallArea;
import com.pz.basic.mall.service.sys.MallAreaService;

import java.util.ArrayList;
import java.util.List;


public class MallAreaServiceImpl implements MallAreaService {
    private MallAreaDao mallAreaDao;

    public void setMallAreaDao(MallAreaDao mallAreaDao) {
        this.mallAreaDao = mallAreaDao;
    }

    @Override
    public Result<MallArea> addMallArea(MallArea mallArea) {
        Result<MallArea> result = new Result<MallArea>();
        try {
            QueryMallArea QueryMallArea = new QueryMallArea();
            QueryMallArea.setAreaName(mallArea.getAreaName());
            long count = mallAreaDao.countByQuery(QueryMallArea);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallArea.getAreaName() + "市已经存在");
                return result;
            }
            mallArea.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallAreaDao.insertMallArea(mallArea);
            result.addDefaultModel(mallArea);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallAreaById(MallArea mallArea) {
        Result result = new Result();
        try {
            int count = mallAreaDao.updateMallAreaByIdModified(mallArea);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public Result deleteMallAreaById(MallArea mallArea) {
        Result result = new Result();
        try {
            long count = 0;
            MallArea modifiedMallArea = new MallArea();
            modifiedMallArea.setId(mallArea.getId());
            modifiedMallArea.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            count = mallAreaDao.updateMallAreaByIdModified(modifiedMallArea);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return null;
    }

    @Override
    public Result<List<MallArea>> getMallAreasByQuery(QueryMallArea queryMallArea) {
        Result<List<MallArea>> result = new Result<List<MallArea>>();
        try {
            queryMallArea.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            result.addDefaultModel("MallAreas", mallAreaDao.selectMallAreaByQuery(queryMallArea));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return null;
    }

    @Override
    public Result<MallArea> getMallAreaById(long id) {
        Result<MallArea> result = new Result<MallArea>();
        try {
            result.addDefaultModel("MallArea", mallAreaDao.selectMallAreaById(id));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallArea>> getMallAreasByPage(QueryMallArea queryMallArea) {
        Result<List<MallArea>> result = new Result<List<MallArea>>();
        queryMallArea.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallAreaDao.countByQuery(queryMallArea);
        queryMallArea.setTotalItem(totalItem);
        if (totalItem > 0) {
            result.addDefaultModel(mallAreaDao.selectMallAreaByPage(queryMallArea));
        } else {
            result.addDefaultModel(new ArrayList<MallArea>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallArea.getPageSize());
        result.setPage(queryMallArea.getPage());
        return result;
    }

    @Override
    public Result<Long> count(QueryMallArea queryMallArea) {
        Result<Long> result = new Result<Long>();
        queryMallArea.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        try {
            result.addDefaultModel(mallAreaDao.countByQuery(queryMallArea));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result disableEnableMallAreaList(List<MallArea> areaList, boolean disable) {
        Result result = new Result();
        try {
            for (MallArea mallArea:areaList) {
                if (disable) {
                    mallArea.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
                } else {
                    mallArea.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
                }
                mallAreaDao.updateMallAreaByIdModified(mallArea);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
    @Override
    public Result deleteMallAreaList(List<MallArea> areaList) {
        return null;
    }

}
