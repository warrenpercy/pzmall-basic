package com.pz.basic.mall.controller.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallCity;
import com.pz.basic.mall.domain.sys.query.QueryMallCity;
import com.pz.basic.mall.service.sys.MallCityService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:19
 */

@RestController
@RequestMapping("/cityManage")
public class MallCityController {

    private MallCityService mallCityService;

    public void setMallCityService(MallCityService mallCityService) {
        this.mallCityService = mallCityService;
    }

    /**
     * 新增城市
     * @param mallCity
     * @return
     */
    @RequestMapping("/addMallCity")
    public Result<MallCity> addMallCity(@RequestBody MallCity mallCity){
        try {
            return mallCityService.addMallCity(mallCity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改城市
     * @param mallCity
     * @return
     */
    @RequestMapping("/updateMallCity")
    public Result updateMallCity(@RequestBody MallCity mallCity) {
        try {
            return mallCityService.updateMallCityById(mallCity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回城市列表
     * @param queryMallCity
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallCity>> findByPage(@RequestBody QueryMallCity queryMallCity) {
        return mallCityService.getMallCitysByPage(queryMallCity);
    }
}
