package com.pz.basic.mall.service.product.fncategory.impl;

import com.pz.basic.mall.dao.product.fncategory.MallFnCategoryBillboardDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategoryBillboard;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategoryBillboard;
import com.pz.basic.mall.service.product.fncategory.MallFnCategoryBillboardService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:50
 */
public class MallFnCategoryBillboardServiceImpl implements MallFnCategoryBillboardService {
    private MallFnCategoryBillboardDao mallFnCategoryBillboardDao;

    public void setMallFnCategoryBillboardDao(MallFnCategoryBillboardDao mallFnCategoryBillboardDao) {
        this.mallFnCategoryBillboardDao = mallFnCategoryBillboardDao;
    }

    public Result<MallFnCategoryBillboard> addMallFnCategoryBillboard(MallFnCategoryBillboard mallFnCategoryBillboard) {
        Result<MallFnCategoryBillboard> result = new Result<MallFnCategoryBillboard>();
        try {
            mallFnCategoryBillboardDao.insertMallFnCategoryBillboardModified(mallFnCategoryBillboard);
            result.addDefaultModel(mallFnCategoryBillboard);
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result updateMallFnCategoryBillboardById(MallFnCategoryBillboard mallFnCategoryBillboard) {
        Result result = new Result();
        try {
            int count= mallFnCategoryBillboardDao.updateMallFnCategoryBillboardByIdModified(mallFnCategoryBillboard);
            if(count>0){
                result.setSuccess(true);
            }
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result deleteMallFnCategoryBillboardById(long id) {
        Result result = new Result();
        try {
            int count= mallFnCategoryBillboardDao.deleteMallFnCategoryBillboardById(id);
            if(count>0){
                result.setSuccess(true);
            }
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result<List<MallFnCategoryBillboard>> getMallFnCategoryBillboardsByQuery(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard) {
        Result<List<MallFnCategoryBillboard>> result = new Result<List<MallFnCategoryBillboard>>();
        try {
            result.addDefaultModel( mallFnCategoryBillboardDao.selectMallFnCategoryBillboardByQuery(queryMallFnCategoryBillboard));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    public Result<MallFnCategoryBillboard> getMallFnCategoryBillboardById(long id) {
        Result<MallFnCategoryBillboard> result = new Result<MallFnCategoryBillboard>();
        try {
            result.addDefaultModel(mallFnCategoryBillboardDao.selectMallFnCategoryBillboardById(id));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }


    public Result<List<MallFnCategoryBillboard>> getMallFnCategoryBillboardsByPage(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard) {

        Result<List<MallFnCategoryBillboard>> result = new Result<List<MallFnCategoryBillboard>>();
        long totalItem = mallFnCategoryBillboardDao.countByQuery(queryMallFnCategoryBillboard);
        queryMallFnCategoryBillboard.setTotalItem(totalItem);
        queryMallFnCategoryBillboard.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel( mallFnCategoryBillboardDao.selectMallFnCategoryBillboardByPage(queryMallFnCategoryBillboard));
        } else {
            result.addDefaultModel(new ArrayList<MallFnCategoryBillboard>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallFnCategoryBillboard.getPageSize());
        result.setPage(queryMallFnCategoryBillboard.getPage());

        return result;
    }

    public Result<Long> count(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard) {
        Result<Long> result = new Result<Long>();
        try {
            result.addDefaultModel(mallFnCategoryBillboardDao.countByQuery(queryMallFnCategoryBillboard));
        } catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
}
