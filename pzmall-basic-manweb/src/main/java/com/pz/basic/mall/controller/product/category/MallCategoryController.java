package com.pz.basic.mall.controller.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategory;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategory;
import com.pz.basic.mall.service.product.category.MallCategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:31
 */
@RestController
@RequestMapping("/category")
public class MallCategoryController {

    private MallCategoryService mallCategoryService;


    public void setMallCategoryService(MallCategoryService mallCategoryService) {
        this.mallCategoryService = mallCategoryService;
    }

    /**
     * 新增类目
     * @param mallCategory
     * @return
     */
    @RequestMapping("/addMallCategory")
    public Result<MallCategory> addMallCategory(@RequestBody MallCategory mallCategory){
        try{
            return mallCategoryService.addMallCategory(mallCategory);
        }catch(Exception e){
            return new Result(false);
        }
    }

    /**
     * 修改类目
     * @param mallCategory
     * @return
     */
    @RequestMapping("/updateMallCategory")
    public Result updateMallCategory(@RequestBody MallCategory mallCategory){
        try{
            return  mallCategoryService.updateMallCategoryById(mallCategory);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回类目列表
     * @param queryMallCategory
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List<MallCategory>> findByPage(@RequestBody QueryMallCategory queryMallCategory){
        return mallCategoryService.getMallCategorysByPage(queryMallCategory);
    }


    /**
     * 不分页返回类目列表
     * @param queryMallCategory
     * @return
     */
    @RequestMapping("/findByQuery")
    public  Result<List<MallCategory>> findByQuery(@RequestBody QueryMallCategory queryMallCategory){
        return mallCategoryService.getMallCategorysByQuery(queryMallCategory);
    }

}
