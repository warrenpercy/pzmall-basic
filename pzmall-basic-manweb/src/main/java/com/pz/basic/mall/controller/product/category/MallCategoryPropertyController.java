package com.pz.basic.mall.controller.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategoryProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;
import com.pz.basic.mall.domain.product.property.vo.MallCategoryPropertyVo;
import com.pz.basic.mall.domain.product.property.vo.MallGroupVo;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryProperty;
import com.pz.basic.mall.service.product.category.MallCategoryPropertyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/19 14:36
 */
@RestController
@RequestMapping("/category_property")
public class MallCategoryPropertyController {
    private MallCategoryPropertyService mallCategoryPropertyService;

    public void setMallCategoryPropertyService(MallCategoryPropertyService mallCategoryPropertyService) {
        this.mallCategoryPropertyService = mallCategoryPropertyService;
    }

    /**
     * 批量新增类目属性
     * @param mallCategoryPropertyList
     * @return
     */
    @RequestMapping("/addMallCategoryPropertyBatch")
    public Result<List<MallCategoryProperty>> addMallCategoryProperty(@RequestBody List<MallCategoryProperty> mallCategoryPropertyList){
        try{
            return mallCategoryPropertyService.addMallCategoryPropertyBatch(mallCategoryPropertyList);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改类目属性
     * @param mallCategoryProperty
     * @return
     */
    @RequestMapping("/updateMallCategoryProperty")
    public Result updateMallCategoryProperty(@RequestBody MallCategoryProperty mallCategoryProperty){
        try{
            return  mallCategoryPropertyService.updateMallCategoryPropertyById(mallCategoryProperty);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回类目属性列表
     * @param queryMallCategoryProperty
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List<MallCategoryProperty>> findByPage(@RequestBody QueryMallCategoryProperty queryMallCategoryProperty){
        return mallCategoryPropertyService.getMallCategoryPropertysByPage(queryMallCategoryProperty);
    }

    /**
     * 删除类目属性
     * @param mallCategoryProperty
     * @return
     */
    @RequestMapping("/deleteMallCategoryProperty")
    public Result deleteMallCategoryProperty(@RequestBody MallCategoryProperty mallCategoryProperty){
        try{
            MallCategoryProperty updateMallCategoryProperty = new MallCategoryProperty();
            updateMallCategoryProperty.setCategoryPropertyId(mallCategoryProperty.getCategoryPropertyId());
            updateMallCategoryProperty.setStatus(-1);
            return  mallCategoryPropertyService.updateMallCategoryPropertyById(updateMallCategoryProperty);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回类目属性列表
     * @param queryMallProperty
     * @return
     */
    @RequestMapping("/findForSelect")
    public Result<List<MallGroupVo>> findForSelect(@RequestBody QueryMallProperty queryMallProperty) {
        return mallCategoryPropertyService.getMallPropertyGroup(queryMallProperty);
    }

    /**
     * 返回商品发布所需要的类目属性列表
     * @param queryMallCategoryProperty
     * @return
     */
    @RequestMapping("/findForReleaseProduct")
    public  Result<List<MallCategoryPropertyVo>> findForReleaseProduct(@RequestBody QueryMallCategoryProperty queryMallCategoryProperty){
        return mallCategoryPropertyService.findForReleaseProduct(queryMallCategoryProperty);
    }

}
