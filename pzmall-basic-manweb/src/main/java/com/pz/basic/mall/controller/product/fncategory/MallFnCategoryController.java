package com.pz.basic.mall.controller.product.fncategory;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;
import com.pz.basic.mall.domain.product.category.vo.MallCategoryVo;
import com.pz.basic.mall.domain.product.fncategory.MallFnBgCategoryRel;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategory;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnBgCategoryRel;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategory;
import com.pz.basic.mall.service.product.category.MallCategoryService;
import com.pz.basic.mall.service.product.fncategory.MallFnBgCategoryRelService;
import com.pz.basic.mall.service.product.fncategory.MallFnCategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:07
 */
@RestController
@RequestMapping("/fncategory")
public class MallFnCategoryController {
    private MallFnCategoryService mallFnCategoryService;
    private MallCategoryService mallCategoryService;
    private MallFnBgCategoryRelService mallFnBgCategoryRelService;

    public void setMallFnBgCategoryRelService(MallFnBgCategoryRelService mallFnBgCategoryRelService) {
        this.mallFnBgCategoryRelService = mallFnBgCategoryRelService;
    }

    public void setMallCategoryService(MallCategoryService mallCategoryService) {
        this.mallCategoryService = mallCategoryService;
    }

    public void setMallFnCategoryService(MallFnCategoryService mallFnCategoryService) {
        this.mallFnCategoryService = mallFnCategoryService;
    }

    /**
     * 新增类目
     * @param mallFnCategory
     * @return
     */
    @RequestMapping("/addMallFnCategory")
    public Result<MallFnCategory>  addMallFnCategory(@RequestBody MallFnCategory mallFnCategory){
        try{
            return mallFnCategoryService.addMallFnCategory(mallFnCategory);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 根据ID查找类目
     * @param id
     * @return
     */
    @RequestMapping("/findMallFnCategoryById")
    public Result<MallFnCategory> findMallFnCategoryById(Long id){
        return mallFnCategoryService.getMallFnCategoryById(id.intValue());
    }

    /**
     * 修改类目
     * @param mallFnCategory
     * @return
     */
    @RequestMapping("/updateMallFnCategory")
    public Result updateMallFnCategory(@RequestBody MallFnCategory mallFnCategory){
        try{
            return  mallFnCategoryService.updateMallFnCategoryById(mallFnCategory);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回类目列表
     * @param queryMallFnCategory
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List<MallFnCategory>> findByPage(@RequestBody QueryMallFnCategory queryMallFnCategory){
        return mallFnCategoryService.getMallFnCategorysByPage(queryMallFnCategory);
    }

    /**
     * 返回用于选择的后台类目
     * @param queryMallFnBgCategoryRel
     * @return
     */
    @RequestMapping("/findForSelect")
    public  Result<List<MallCategoryVo>> findForSelect(@RequestBody QueryMallFnBgCategoryRel queryMallFnBgCategoryRel){
        QueryMallCategory queryMallCategory = new QueryMallCategory();
        Result<List<MallCategoryVo>> dataResult= mallCategoryService.getMallCategoryVoList(queryMallCategory,null);
        return dataResult;

    }


    /**
     * 返回前台类目后台类目关系列表
     * @param queryMallFnBgCategoryRel
     * @return
     */
    @RequestMapping("/findForSelectedTable")
    public  Result<List<MallFnBgCategoryRel>> findForSelectedTable(@RequestBody QueryMallFnBgCategoryRel queryMallFnBgCategoryRel){

        Result<List<MallFnBgCategoryRel>>  result =  mallFnBgCategoryRelService.getMallFnBgCategoryRelsByQueryWithCateName(queryMallFnBgCategoryRel);
        return result;

    }

    /**
     * 批量新增前后台类目关系
     * @param mallFnBgCategoryRelList
     * @return
     */
    @RequestMapping("/addMallFnBgCategoryRelBatch")
    public Result<List<MallFnBgCategoryRel>> addMallCategoryPropertyValueBatch(@RequestBody List<MallFnBgCategoryRel> mallFnBgCategoryRelList){
        try{
            return mallFnBgCategoryRelService.addMallFnBgCategoryRelBatch(mallFnBgCategoryRelList);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }
}
