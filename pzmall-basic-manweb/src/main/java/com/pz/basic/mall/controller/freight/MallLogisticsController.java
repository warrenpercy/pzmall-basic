package com.pz.basic.mall.controller.freight;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.freight.MallLogistics;
import com.pz.basic.mall.domain.freight.query.QueryMallLogistics;
import com.pz.basic.mall.service.freight.MallLogisticsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/21 16:32
 */
@RestController
@RequestMapping("/logistics")
public class MallLogisticsController {
    private MallLogisticsService mallLogisticsService;

    public void setMallLogisticsService(MallLogisticsService mallLogisticsService) {
        this.mallLogisticsService = mallLogisticsService;
    }

    /**
     * 新增物流供应商
     * @param mallLogistics
     * @return
     */
    @RequestMapping("/addMallLogistics")
    public Result<MallLogistics> addMallLogistics(@RequestBody MallLogistics mallLogistics){
        try{
            return  mallLogisticsService.addMallLogistics(mallLogistics);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 修改物流供应商
     * @param mallLogistics
     * @return
     */
    @RequestMapping("/updateMallLogistics")
    public Result updateMallLogistics(@RequestBody MallLogistics mallLogistics){
        try{
            return mallLogisticsService.updateMallLogisticsById(mallLogistics);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 启用物流供应商
     * @param mallLogistics
     * @return
     */
    @RequestMapping("/enableMallLogistics")
    public Result enableMallLogistics(@RequestBody MallLogistics mallLogistics){
        try{
            MallLogistics modifiedData =new MallLogistics ();
            modifiedData.setId(mallLogistics.getId());
            modifiedData.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            return mallLogisticsService.updateMallLogisticsById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 停用物流供应商
     * @param mallLogistics
     * @return
     */
    @RequestMapping("/disableMallLogistics")
    public Result disableMallLogistics(@RequestBody MallLogistics mallLogistics){
        try{
            MallLogistics modifiedData =new MallLogistics ();
            modifiedData.setId(mallLogistics.getId());
            modifiedData.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            return mallLogisticsService.updateMallLogisticsById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 删除物流供应商
     * @param mallLogistics
     * @return
     */
    @RequestMapping("/deleteMallLogistics")
    public Result deleteMallLogistics(@RequestBody MallLogistics mallLogistics){
        try{
            MallLogistics modifiedData =new MallLogistics ();
            modifiedData.setId(mallLogistics.getId());
            modifiedData.setStatus(DataStatusEnum.STATUS_DELETED.getStatusValue());
            return mallLogisticsService.updateMallLogisticsById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回物流供应商列表
     * @param queryMallLogistics
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List<MallLogistics>> findByPage(@RequestBody QueryMallLogistics queryMallLogistics){
        return mallLogisticsService.getMallLogisticssByPage(queryMallLogistics);
    }
}
