package com.pz.basic.mall.controller.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallPropertyValue;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyValue;
import com.pz.basic.mall.service.product.property.MallPropertyValueService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 9:22
 */
@RestController
@RequestMapping("/propertyValue")
public class MallPropertyValueController {

    private MallPropertyValueService mallPropertyValueService;

    public void setMallPropertyValueService(MallPropertyValueService mallPropertyValueService) {
        this.mallPropertyValueService = mallPropertyValueService;
    }

    /**
     * 新增属性
     *
     * @param mallPropertyValue
     * @return
     */
    @RequestMapping("/addMallPropertyValue")
    public Result<MallPropertyValue> addMallPropertyValue(@RequestBody MallPropertyValue mallPropertyValue) {
        try {
            return mallPropertyValueService.addMallPropertyValue(mallPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改属性
     *
     * @param mallPropertyValue
     * @return
     */
    @RequestMapping("/updateMallPropertyValue")
    public Result updateMallPropertyValue(@RequestBody MallPropertyValue mallPropertyValue) {
        try {
            return mallPropertyValueService.updateMallPropertyValueById(mallPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回属性列表
     *
     * @param queryMallPropertyValue
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallPropertyValue>> findByPage(@RequestBody QueryMallPropertyValue queryMallPropertyValue) {
        return mallPropertyValueService.getMallPropertyValuesByPage(queryMallPropertyValue);
    }

    /**
     * 删除属性
     *
     * @param mallPropertyValue
     * @return
     */
    @RequestMapping("/deleteMallPropertyValue")
    public Result deleteMallPropertyValue(@RequestBody MallPropertyValue mallPropertyValue) {
        try {
            return mallPropertyValueService.deleteMallPropertyValueById(mallPropertyValue.getPropertyValueId());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

}
