package com.pz.basic.mall.controller.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallProvince;
import com.pz.basic.mall.domain.sys.query.QueryMallProvince;
import com.pz.basic.mall.service.sys.MallProvinceService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:18
 */

@RestController
@RequestMapping("/provinceManage")
public class MallProvinceController {

    private MallProvinceService mallProvinceService;

    public void setMallProvinceService(MallProvinceService mallProvinceService) {
        this.mallProvinceService = mallProvinceService;
    }

    /**
     * 新增省
     * @param mallProvince
     * @return
     */
    @RequestMapping("/addMallProvince")
    public Result<MallProvince> addMallProvince(@RequestBody MallProvince mallProvince) {
        try {
            return mallProvinceService.addMallProvince(mallProvince);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改省
     * @param mallProvince
     * @return
     */
    @RequestMapping("/updateMallProvince")
    public Result updateMallProvince(@RequestBody MallProvince mallProvince) {
        try {
            return mallProvinceService.updateMallProvinceById(mallProvince);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回省列表
     * @param queryMallProvince
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallProvince>> findByPage(@RequestBody QueryMallProvince queryMallProvince) {
        return mallProvinceService.getMallProvincesByPage(queryMallProvince);
    }
}
