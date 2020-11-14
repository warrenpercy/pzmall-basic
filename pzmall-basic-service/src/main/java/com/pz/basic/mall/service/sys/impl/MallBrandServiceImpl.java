package com.pz.basic.mall.service.sys.impl;

import com.pz.basic.mall.dao.sys.MallBrandDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataActiveStatusEnum;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.sys.MallBrand;
import com.pz.basic.mall.domain.sys.query.QueryMallBrand;
import com.pz.basic.mall.service.sys.MallBrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/8/21 10:37
 */
//@Service(value="mallBrandService")
public class MallBrandServiceImpl implements MallBrandService {

    private MallBrandDao mallBrandDao;

    public void setMallBrandDao(MallBrandDao mallBrandDao) {
        this.mallBrandDao =mallBrandDao;
    }

    public Result<MallBrand> addMallBrand(MallBrand mallBrand) {
        Result<MallBrand> result = new Result<MallBrand>();
        try {
            QueryMallBrand query = new QueryMallBrand();
            query.setBrandName(mallBrand.getBrandName());
            long count = mallBrandDao.countByQuery(query);
            if(count>0){
                result.setSuccess(false);
                result.setMessage("品牌名已存在");
                return result;
            }
            mallBrand.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallBrand.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
            mallBrandDao.insertMallBrand(mallBrand);
            result.addDefaultModel(mallBrand);
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result updateMallBrandById(MallBrand mallBrand) {
        Result result = new Result();
        try {
            int count=mallBrandDao.updateMallBrandByIdModified(mallBrand);
            if(count>0){
                result.setSuccess(true);
            }
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result deleteMallBrandById(MallBrand mallBrand) {
        Result result = new Result();
        try {
            int count=0;
            MallBrand modifiedMallBrand = new MallBrand();
            modifiedMallBrand.setId(mallBrand.getId());
            modifiedMallBrand.setActive(DataActiveStatusEnum.STATUS_DELETED.getStatusValue());
            count=mallBrandDao.updateMallBrandByIdModified(modifiedMallBrand);
            if(count>0){
                result.setSuccess(true);
            }
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result<List<MallBrand>> getMallBrandsByQuery(QueryMallBrand queryMallBrand) {
        Result<List<MallBrand>> result = new Result<List<MallBrand>>();
        try {
            queryMallBrand.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
            result.addDefaultModel("MallBrands", mallBrandDao.selectMallBrandByQuery(queryMallBrand));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result<MallBrand> getMallBrandById(long id) {
        Result<MallBrand> result = new Result<MallBrand>();
        try {
            result.addDefaultModel("MallBrand", mallBrandDao.selectMallBrandById(id));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }


    public Result<List<MallBrand>> getMallBrandsByPage(QueryMallBrand queryMallBrand) {

        Result<List<MallBrand>> result = new Result<List<MallBrand>>();
        queryMallBrand.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
        long totalItem =mallBrandDao.countByQuery(queryMallBrand);
        queryMallBrand.setTotalItem(totalItem);
        queryMallBrand.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallBrandDao.selectMallBrandByPage(queryMallBrand));
        } else {
            result.addDefaultModel(new ArrayList<MallBrand>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallBrand.getPageSize());
        result.setPage(queryMallBrand.getPage());

        return result;
    }

    public Result<Long> count(QueryMallBrand queryMallBrand) {
        Result<Long> result = new Result<Long>();
        queryMallBrand.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
        try {
            result.addDefaultModel(mallBrandDao.countByQuery(queryMallBrand));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }


    public Result disableEnableMallBrandList(List<MallBrand> brandList, boolean disable) {

        Result result = new Result();
        try {
            for (MallBrand brand : brandList) {
                if (disable) {
                    brand.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
                } else {
                    brand.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
                }
                mallBrandDao.updateMallBrandByIdModified(brand);
            }
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result;
    }

    public Result deleteMallBrandList(List<MallBrand> brandList){
        Result result = new Result();
        try {
            for (MallBrand brand : brandList) {
                brand.setActive(DataActiveStatusEnum.STATUS_DELETED.getStatusValue());
                mallBrandDao.updateMallBrandByIdModified(brand);
            }
        }catch(Exception e){
            result.setSuccess(false);
        }
        return result;
    }

}
