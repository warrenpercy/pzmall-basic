package com.pz.basic.mall.service.product.category.impl;

import com.pz.basic.mall.dao.product.category.MallCategoryDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataActiveStatusEnum;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.category.MallCategory;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;
import com.pz.basic.mall.domain.product.category.vo.MallCategoryVo;
import com.pz.basic.mall.service.product.category.MallCategoryService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author percy
 * @date 2020/9/18 7:39
 */
public class MallCategoryServiceImpl implements MallCategoryService {
    private MallCategoryDao mallCategoryDao;

    public void setMallCategoryDao(MallCategoryDao mallCategoryDao) {
        this.mallCategoryDao = mallCategoryDao;
    }

    @Override
    public Result<MallCategory> addMallCategory(MallCategory mallCategory) {
        Result<MallCategory> result = new Result<MallCategory>();
        try {
            QueryMallCategory query = new QueryMallCategory();
            query.setCategoryName(mallCategory.getCategoryName());
            long count = mallCategoryDao.countByQuery(query);
            if (count > 0) {
                result.setSuccess(false);
                result.setMessage(mallCategory.getCategoryName() + "类目已经存在");
                return result;
            }
            mallCategory.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            mallCategory.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
            mallCategoryDao.insertMallCategory(mallCategory);
            result.addDefaultModel(mallCategory);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallCategoryById(MallCategory mallCategory) {
        Result result = new Result();
        try {
            int count = mallCategoryDao.updateMallCategoryByIdModified(mallCategory);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallCategory>> getMallCategorysByPage(QueryMallCategory queryMallCategory) {
        Result<List<MallCategory>> result = new Result<List<MallCategory>>();
        queryMallCategory.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
        long totalItem = mallCategoryDao.countByQuery(queryMallCategory);
        queryMallCategory.setTotalItem(totalItem);
        queryMallCategory.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallCategoryDao.selectMallCategoryByQuery(queryMallCategory));
        } else {
            result.addDefaultModel(new ArrayList<MallCategory>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallCategory.getPageSize());
        result.setPage(queryMallCategory.getPage());
        return result;
    }

    @Override
    public Result<List<MallCategory>> getMallCategorysByQuery(QueryMallCategory queryMallCategory) {
        Result<List<MallCategory>> result = new Result<List<MallCategory>>();
        try {
            queryMallCategory.setActive(DataActiveStatusEnum.STATUS_ACTIVE.getStatusValue());
            result.addDefaultModel("MallCategorys", mallCategoryDao.selectMallCategoryByQuery(queryMallCategory));
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取需要展示的类目
     *
     * @param queryMallCategory
     * @param exculdeIdlist
     * @return
     */
    @Override
    public Result<List<MallCategoryVo>> getMallCategoryVoList(QueryMallCategory queryMallCategory, List<Long> exculdeIdlist) {
        Result<List<MallCategoryVo>> result = new Result<List<MallCategoryVo>>();
        try {
            List<MallCategory> dataList = mallCategoryDao.selectMallCategoryByQuery(queryMallCategory);
            //删除需要屏蔽的对象
            if (!CollectionUtils.isEmpty(exculdeIdlist)) {
                dataList.removeIf(a -> {
                    return exculdeIdlist.stream().anyMatch(b -> {
                        return b != null && b.equals(a.getCategoryId());
                    });
                });
            }
            List<MallCategoryVo> voList = new ArrayList<MallCategoryVo>();
            result.addDefaultModel(voList);
            for (MallCategory category : dataList) {

                if (category.getLevel() == 1) {
                    MallCategoryVo vo = new MallCategoryVo();
                    vo.setCategoryId(category.getCategoryId());
                    vo.setCategoryName(category.getCategoryName());
                    vo.setLevel(category.getLevel());
                    voList.add(vo);
                    setChildren(dataList, vo);
                }

            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 递归设置子节点
     *
     * @param dataList
     * @param mallCategoryVo
     */
    private void setChildren(List<MallCategory> dataList, MallCategoryVo mallCategoryVo) {
        for (MallCategory category : dataList) {
            if (mallCategoryVo.getCategoryId().equals(category.getParentId())) {
                MallCategoryVo child = new MallCategoryVo();
                child.setCategoryId(category.getCategoryId());
                child.setCategoryName(category.getCategoryName());
                child.setLevel(category.getLevel());
                mallCategoryVo.getChildren().add(child);
                setChildren(dataList, child);
            }

        }
    }

}
