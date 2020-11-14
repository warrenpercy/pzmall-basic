package com.pz.basic.mall.service.sys.impl;

import com.pz.basic.mall.dao.sys.MallProvinceDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.sys.MallProvince;
import com.pz.basic.mall.domain.sys.query.QueryMallProvince;
import com.pz.basic.mall.service.sys.MallProvinceService;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 16:12
 */
public class MallProvinceServiceImpl implements MallProvinceService {

    private MallProvinceDao mallProvinceDao;

    public void setMallProvinceDao(MallProvinceDao mallProvinceDao) {
        this.mallProvinceDao = mallProvinceDao;
    }

    @Override
    public Result<MallProvince> addMallProvince(MallProvince mallProvince) {
        Result<MallProvince> result = new Result<MallProvince>();
        try {
            QueryMallProvince query = new QueryMallProvince();
            query.setProvinceName(mallProvince.getProvinceName());
            long count = mallProvinceDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallProvince.getProvinceName() + "省已经存在");
                return  result;
            }
            mallProvince.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallProvinceDao.insertMallProvince(mallProvince);
            result.addDefaultModel(mallProvince);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallProvinceById(MallProvince mallProvince) {
        Result result = new Result();
        try {
            int count = mallProvinceDao.updateMallProvinceByIdModified(mallProvince);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result deleteMallProvinceById(MallProvince mallProvince) {
        Result result = new Result();
        try {
            long count = 0;
            MallProvince modifiedMallProvince = new MallProvince();
            modifiedMallProvince.setId(mallProvince.getId());
            modifiedMallProvince.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            count = mallProvinceDao.updateMallProvinceByIdModified(modifiedMallProvince);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallProvince>> getMallProvincesByQuery(QueryMallProvince queryMallProvince) {
        Result<List<MallProvince>> result = new Result<List<MallProvince>>();
        try {
            queryMallProvince.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            result.addDefaultModel("MallProvinces", mallProvinceDao.selectMallProvinceByQuery(queryMallProvince));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<MallProvince> getMallProvinceById(long id) {
        Result<MallProvince> result = new Result<MallProvince>();
        try {
            result.addDefaultModel("MallProvince", mallProvinceDao.selectMallProvinceById(id));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallProvince>> getMallProvincesByPage(QueryMallProvince queryMallProvince) {
        Result<List<MallProvince>> result = new Result<List<MallProvince>>();
        queryMallProvince.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        long totalItem = mallProvinceDao.countByQuery(queryMallProvince);
        queryMallProvince.setTotalItem(totalItem);
        if (totalItem > 0) {
            result.addDefaultModel(mallProvinceDao.selectMallProvinceByPage(queryMallProvince));
        } else {
            result.addDefaultModel(new ArrayList<MallProvince>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallProvince.getPageSize());
        result.setPage(queryMallProvince.getPage());
        return result;
    }

    @Override
    public Result<Long> count(QueryMallProvince queryMallProvince) {
        Result<Long> result = new Result<Long>();
        queryMallProvince.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        try {
            result.addDefaultModel(mallProvinceDao.countByQuery(queryMallProvince));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result disableEnableMallProvinceList(List<MallProvince> provinceList, boolean disable) {
        Result result = new Result();
        try {
            for (MallProvince mallProvince:provinceList) {
                if (disable) {
                    mallProvince.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
                } else {
                    mallProvince.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
                }
                mallProvinceDao.updateMallProvinceByIdModified(mallProvince);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result deleteMallProvinceList(List<MallProvince> ProvinceList) {
        return null;
    }
}
