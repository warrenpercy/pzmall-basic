package com.pz.basic.mall.controller.product.fncategory;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategoryBillboard;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategoryBillboard;
import com.pz.basic.mall.service.product.fncategory.MallFnCategoryBillboardService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:49
 */
@RestController
@RequestMapping("/fncategorybillboard")
public class MallFnCategoryBillboardController {
    private MallFnCategoryBillboardService mallFnCategoryBillboardService;

    public void setMallFnCategoryBillboardService(MallFnCategoryBillboardService mallFnCategoryBillboardService) {
        this.mallFnCategoryBillboardService = mallFnCategoryBillboardService;
    }

    /**
     * 新增广告牌
     * @param  mallFnCategoryBillboard
     * @return
     */
    @RequestMapping("/addMallFnCategoryBillboard")
    public Result< MallFnCategoryBillboard>  addMallFnCategoryBillboard(@RequestBody  MallFnCategoryBillboard  mallFnCategoryBillboard){
        try{
            return  mallFnCategoryBillboardService.addMallFnCategoryBillboard( mallFnCategoryBillboard);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 根据ID查找广告牌
     * @param mallFnCategoryBillboard
     * @return
     */
    @RequestMapping("/findMallFnCategoryBillboardById")
    public Result<MallFnCategoryBillboard> findMallFnCategoryBillboardById(@RequestBody MallFnCategoryBillboard  mallFnCategoryBillboard){
        return  mallFnCategoryBillboardService.getMallFnCategoryBillboardById(mallFnCategoryBillboard.getId());
    }

    /**
     * 修改广告牌
     * @param  mallFnCategoryBillboard
     * @return
     */
    @RequestMapping("/updateMallFnCategoryBillboard")
    public Result updateMallFnCategoryBillboard(@RequestBody  MallFnCategoryBillboard  mallFnCategoryBillboard){
        try{
            return   mallFnCategoryBillboardService.updateMallFnCategoryBillboardById(mallFnCategoryBillboard);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回广告牌列表
     * @param queryMallFnCategoryBillboard
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List< MallFnCategoryBillboard>> findByPage(@RequestBody QueryMallFnCategoryBillboard queryMallFnCategoryBillboard){
        return  mallFnCategoryBillboardService.getMallFnCategoryBillboardsByPage(queryMallFnCategoryBillboard);
    }
}
