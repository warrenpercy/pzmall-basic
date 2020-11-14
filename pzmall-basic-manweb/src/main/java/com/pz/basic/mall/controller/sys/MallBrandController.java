/**
 * Copyright(c) 2004-2020pangzi
 * com.pz.basic.mall.controller.sys.MallBrandController.java
 */
package com.pz.basic.mall.controller.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.sys.MallBrand;
import com.pz.basic.mall.domain.sys.query.QueryMallBrand;
import com.pz.basic.mall.service.sys.MallBrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 *
 * @author pangzi
 * @date 2020-06-2220:47:27
 *
 *
 */
@RestController
@RequestMapping("/brandManage")
public class MallBrandController {


    private MallBrandService mallBrandService;


    public void setMallBrandService(MallBrandService mallBrandService) {
        this.mallBrandService = mallBrandService;
    }


    /**
     * 新增品牌
     * @param mallBrand
     * @return
     */
    @RequestMapping("/addMallBrand")
    public Result<MallBrand> addMallBrand(@RequestBody MallBrand mallBrand) {
        try {

            return mallBrandService.addMallBrand(mallBrand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 修改品牌
     * @param mallBrand
     * @return
     */
    @RequestMapping("/updateMallBrand")
    public Result updateMallBrand(@RequestBody MallBrand mallBrand) {
        try {
            return mallBrandService.updateMallBrandById(mallBrand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 启用品牌
     * @param mallBrand
     * @return
     */
    @RequestMapping("/enableMallBrand")
    public Result enableMallBrand(@RequestBody MallBrand mallBrand) {
        try {
            MallBrand modifiedData = new MallBrand();
            modifiedData.setId(mallBrand.getId());
            modifiedData.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            return mallBrandService.updateMallBrandById(modifiedData);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 停用品牌
     * @param mallBrand
     * @return
     */
    @RequestMapping("/disableMallBrand")
    public Result disableMallBrand(@RequestBody MallBrand mallBrand) {
        try {
            MallBrand modifiedData = new MallBrand();
            modifiedData.setId(mallBrand.getId());
            modifiedData.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            return mallBrandService.updateMallBrandById(modifiedData);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 删除品牌
     * @param mallBrand
     * @return
     */
    @RequestMapping("/deleteMallBrand")
    public Result deleteMallBrand(@RequestBody MallBrand mallBrand) {
        try {
            return mallBrandService.deleteMallBrandById(mallBrand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回品牌列表
     * @paramqueryMallBrand
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallBrand>> findByPage(@RequestBody QueryMallBrand queryMallBrand) {
        return mallBrandService.getMallBrandsByPage(queryMallBrand);
    }


    /**
     * 修改品牌
     * @param brandList
     * @return
     */
    @RequestMapping("/disableMallBrandList")
    public Result disableMallBrandList(@RequestBody List<MallBrand> brandList) {
        try {
            return mallBrandService.disableEnableMallBrandList(brandList, true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改品牌
     * @param brandList
     * @return
     */
    @RequestMapping("/enableMallBrandList")
    public Result enableMallBrandList(@RequestBody List<MallBrand> brandList) {
        try {
            return mallBrandService.disableEnableMallBrandList(brandList, false);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改品牌
     * @param brandList
     * @return
     */
    @RequestMapping("/deleteMallBrandList")
    public Result deleteMallBrandList(@RequestBody List<MallBrand> brandList) {
        try {
            return mallBrandService.deleteMallBrandList(brandList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

}