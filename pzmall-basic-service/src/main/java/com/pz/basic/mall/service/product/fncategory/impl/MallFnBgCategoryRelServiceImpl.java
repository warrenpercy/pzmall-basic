package com.pz.basic.mall.service.product.fncategory.impl;

import com.pz.basic.mall.dao.product.category.MallCategoryDao;
import com.pz.basic.mall.dao.product.fncategory.MallFnBgCategoryRelDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategory;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;
import com.pz.basic.mall.domain.product.fncategory.MallFnBgCategoryRel;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnBgCategoryRel;
import com.pz.basic.mall.service.product.fncategory.MallFnBgCategoryRelService;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author percy
 * @date 2020/9/21 15:25
 */
public class MallFnBgCategoryRelServiceImpl implements MallFnBgCategoryRelService {
    private MallFnBgCategoryRelDao mallFnBgCategoryRelDao;
    private MallCategoryDao mallCategoryDao;

    public void setMallCategoryDao(MallCategoryDao mallCategoryDao) {
        this.mallCategoryDao = mallCategoryDao;
    }

    public void setMallFnBgCategoryRelDao(MallFnBgCategoryRelDao mallFnBgCategoryRelDao) {
        this.mallFnBgCategoryRelDao = mallFnBgCategoryRelDao;
    }

    @Override
    public Result<List<MallFnBgCategoryRel>> getMallFnBgCategoryRelsByQueryWithCateName(QueryMallFnBgCategoryRel queryMallFnBgCategoryRel) {
        Result<List<MallFnBgCategoryRel>> result = new Result<List<MallFnBgCategoryRel>>();
        try {
            List<MallFnBgCategoryRel> mfbcrList =mallFnBgCategoryRelDao.selectMallFnBgCategoryRelByQuery(queryMallFnBgCategoryRel);
            if (!CollectionUtils.isEmpty(mfbcrList)) {
                List<Long> fnCategoryIdList = mfbcrList.stream().map(e -> e.getFnCategoryId()).collect(Collectors.toList());

            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallFnBgCategoryRel>> addMallFnBgCategoryRelBatch(List<MallFnBgCategoryRel> mallFnBgCategoryRelList) {
        Result<List<MallFnBgCategoryRel>> result = new Result<List<MallFnBgCategoryRel>>();
        try {
            QueryMallFnBgCategoryRel query = new QueryMallFnBgCategoryRel();
            query.setFnCategoryId(mallFnBgCategoryRelList.get(0).getFnCategoryId());
            List<MallFnBgCategoryRel> dbList = mallFnBgCategoryRelDao.selectMallFnBgCategoryRelByQuery(query);

            //有即新增无则删除
            for(MallFnBgCategoryRel newRel:mallFnBgCategoryRelList){

                if(null==newRel.getId()){
                    mallFnBgCategoryRelDao.insertMallFnBgCategoryRelModified(newRel);
                    continue;
                }

                for(MallFnBgCategoryRel dbRel:dbList){
                    if(newRel.getId().equals(dbRel.getId())){
                        mallFnBgCategoryRelDao.updateMallFnBgCategoryRelByIdModified(dbRel);
                        continue;
                    }

                }
            }
            //删除列表中没有的记录
            for(MallFnBgCategoryRel dbRel: dbList){
                boolean flag=true;
                for(MallFnBgCategoryRel newRel:mallFnBgCategoryRelList){
                    if(newRel.getId().equals(dbRel.getId())){
                        flag=false;
                    }
                    if(flag){
                        dbRel.setStatus(-1);
                        mallFnBgCategoryRelDao.updateMallFnBgCategoryRelByIdModified(dbRel);
                    }
                }

            }
            result.addDefaultModel(mallFnBgCategoryRelList);
        }catch(Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
}
