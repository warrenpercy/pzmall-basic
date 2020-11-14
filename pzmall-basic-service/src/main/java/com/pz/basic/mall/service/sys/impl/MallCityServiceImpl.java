package com.pz.basic.mall.service.sys.impl;

import com.pz.basic.mall.dao.sys.MallCityDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.sys.MallCity;
import com.pz.basic.mall.domain.sys.query.QueryMallCity;
import com.pz.basic.mall.service.sys.MallCityService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 16:12
 */
public class MallCityServiceImpl implements MallCityService{
    private MallCityDao mallCityDao;

    public void setMallCityDao(MallCityDao mallCityDao) {
        this.mallCityDao = mallCityDao;
    }

    @Override
    public Result<MallCity> addMallCity(MallCity mallCity) {
        Result<MallCity> result = new Result<MallCity>();
        try {
            QueryMallCity queryMallCity = new QueryMallCity();
            queryMallCity.setCityName(mallCity.getCityName());
            long count = mallCityDao.countByQuery(queryMallCity);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallCity.getCityName() + "市已经存在");
                return result;
            }
            mallCity.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallCityDao.insertMallCity(mallCity);
            result.addDefaultModel(mallCity);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallCityById(MallCity mallCity) {
        Result result = new Result();
        try {
            int count = mallCityDao.updateMallCityByIdModified(mallCity);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }

        return result;
    }

    @Override
    public Result deleteMallCityById(MallCity mallCity) {
        Result result = new Result();
        try {
            long count = 0;
            MallCity modifiedMallCity = new MallCity();
            modifiedMallCity.setId(mallCity.getId());
            modifiedMallCity.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            count = mallCityDao.updateMallCityByIdModified(modifiedMallCity);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return null;
    }

    @Override
    public Result<List<MallCity>> getMallCitysByQuery(QueryMallCity queryMallCity) {
        Result<List<MallCity>> result = new Result<List<MallCity>>();
        try {
            queryMallCity.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            result.addDefaultModel("mallCities", mallCityDao.selectMallCityByQuery(queryMallCity));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return null;
    }

    @Override
    public Result<MallCity> getMallCityById(long id) {
        Result<MallCity> result = new Result<MallCity>();
        try {
            result.addDefaultModel("MallCity", mallCityDao.selectMallCityById(id));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallCity>> getMallCitysByPage(QueryMallCity queryMallCity) {
        Result<List<MallCity>> result = new Result<List<MallCity>>();
        queryMallCity.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallCityDao.countByQuery(queryMallCity);
        queryMallCity.setTotalItem(totalItem);
        if (totalItem > 0) {
            result.addDefaultModel(mallCityDao.selectMallCityByPage(queryMallCity));
        } else {
            result.addDefaultModel(new ArrayList<MallCity>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallCity.getPageSize());
        result.setPage(queryMallCity.getPage());
        return result;
    }

    @Override
    public Result<Long> count(QueryMallCity queryMallCity) {
        Result<Long> result = new Result<Long>();
        queryMallCity.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        try {
            result.addDefaultModel(mallCityDao.countByQuery(queryMallCity));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result disableEnableMallCityList(List<MallCity> cityList, boolean disable) {
        Result result = new Result();
        try {
            for (MallCity mallCity:cityList) {
                if (disable) {
                    mallCity.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
                } else {
                    mallCity.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
                }
                mallCityDao.updateMallCityByIdModified(mallCity);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result deleteMallCityList(List<MallCity> cityList) {
        return null;
    }


}
