package com.pz.basic.mall.service.product.fncategory.impl;

import com.pz.basic.mall.dao.product.fncategory.MallFnCategoryDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategory;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategory;
import com.pz.basic.mall.service.product.fncategory.MallFnCategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:09
 */
public class MallFnCategoryServiceImpl implements MallFnCategoryService {
    private MallFnCategoryDao mallFnCategoryDao;

    public void setMallFnCategoryDao(MallFnCategoryDao mallFnCategoryDao) {
        this.mallFnCategoryDao = mallFnCategoryDao;
    }

    @Override
    public Result<MallFnCategory> addMallFnCategory(MallFnCategory mallFnCategory) {
        Result<MallFnCategory> result = new Result<MallFnCategory>();
        try {
            QueryMallFnCategory query = new QueryMallFnCategory();
            query.setFnCategoryName(mallFnCategory.getFnCategoryName());
            long count = mallFnCategoryDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallFnCategory.getFnCategoryName() + "前台类目已经存在");
                return result;
            }
            mallFnCategory.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallFnCategoryDao.insertMallFnCategory(mallFnCategory);
            result.addDefaultModel(mallFnCategory);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<MallFnCategory> getMallFnCategoryById(int id) {
        Result<MallFnCategory> result = new Result<MallFnCategory>();
        try {
            result.addDefaultModel("MallFnCategory", mallFnCategoryDao.selectMallFnCategoryById(id));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallFnCategoryById(MallFnCategory mallFnCategory) {
        Result result = new Result();
        try {
            int count = mallFnCategoryDao.updateMallFnCategoryByIdModified(mallFnCategory);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallFnCategory>> getMallFnCategorysByPage(QueryMallFnCategory queryMallFnCategory) {
        Result<List<MallFnCategory>> result = new Result<List<MallFnCategory>>();
        long totalItem = mallFnCategoryDao.countByQuery(queryMallFnCategory);
        queryMallFnCategory.setTotalItem(totalItem);
        queryMallFnCategory.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallFnCategoryDao.selectMallFnCategoryByPage(queryMallFnCategory));
        } else {
            result.addDefaultModel(new ArrayList<MallFnCategory>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallFnCategory.getPageSize());
        result.setPage(queryMallFnCategory.getPage());
        return result;
    }
}
