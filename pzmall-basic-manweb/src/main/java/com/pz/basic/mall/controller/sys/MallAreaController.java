package com.pz.basic.mall.controller.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallArea;
import com.pz.basic.mall.domain.sys.query.QueryMallArea;
import com.pz.basic.mall.service.sys.MallAreaService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:20
 */

@RestController
@RequestMapping("/areaManage")
public class MallAreaController {
    private MallAreaService mallAreaService;

    public void setMallAreaService(MallAreaService mallAreaService) {
        this.mallAreaService = mallAreaService;
    }

    /**
     * 新增地区
     * @param mallArea
     * @return
     */
    @RequestMapping("/addMallArea")
    public Result<MallArea> addMallArea(@RequestBody MallArea mallArea) {
        try {
            return mallAreaService.addMallArea(mallArea);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改地区
     * @param mallArea
     * @return
     */
    @RequestMapping("/updateMallArea")
    public Result updateMallArea(@RequestBody MallArea mallArea) {
        try {
            return mallAreaService.updateMallAreaById(mallArea);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    @RequestMapping("/findByPage")
    public Result<List<MallArea>> findByPage(@RequestBody QueryMallArea queryMallArea) {
        return mallAreaService.getMallAreasByPage(queryMallArea);
    }
}
