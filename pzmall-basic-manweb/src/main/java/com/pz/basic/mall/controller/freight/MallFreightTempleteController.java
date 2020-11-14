package com.pz.basic.mall.controller.freight;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.freight.MallFreightTemplete;
import com.pz.basic.mall.domain.freight.query.QueryMallFreightTemplete;
import com.pz.basic.mall.domain.product.property.vo.AreaSelectedVo;
import com.pz.basic.mall.service.freight.MallFreightTempleteService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/10/6 9:21
 */
@RestController
@RequestMapping("/freightTemplete")
public class MallFreightTempleteController {
    private MallFreightTempleteService mallFreightTempleteService;

    public void setMallFreightTempleteService(MallFreightTempleteService mallFreightTempleteService) {
        this.mallFreightTempleteService = mallFreightTempleteService;
    }

    /**
     * 新增标准运费
     * @param mallFreightTemplete
     * @return
     */
    @RequestMapping("/addMallFreightTemplete")
    public Result<MallFreightTemplete>  addMallFreightTemplete(@RequestBody MallFreightTemplete mallFreightTemplete){
        try{

            return   mallFreightTempleteService.addMallFreightTemplete(mallFreightTemplete);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 根据ID查找标准运费
     * @param id
     * @return
     */
    @RequestMapping("/findMallFreightTempleteById")
    public  Result<MallFreightTemplete> findMallFreightTempleteById(Long id){
        return mallFreightTempleteService.getMallFreightTempleteById(id);
    }

    /**
     * 修改标准运费
     * @param mallFreightTemplete
     * @return
     */
    @RequestMapping("/updateMallFreightTemplete")
    public Result updateMallFreightTemplete(@RequestBody MallFreightTemplete mallFreightTemplete){
        try{
            return  mallFreightTempleteService.updateMallFreightTempleteById(mallFreightTemplete);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 启用标准运费
     * @param mallFreightTemplete
     * @return
     */
    @RequestMapping("/enableMallFreightTemplete")
    public Result enableMallFreightTemplete(@RequestBody MallFreightTemplete mallFreightTemplete){
        try{
            MallFreightTemplete modifiedData =new MallFreightTemplete ();
            modifiedData.setTempleteId(mallFreightTemplete.getTempleteId());
            modifiedData.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
            return  mallFreightTempleteService.updateMallFreightTempleteById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 停用标准运费
     * @param mallFreightTemplete
     * @return
     */
    @RequestMapping("/disableMallFreightTemplete")
    public Result disableMallFreightTemplete(@RequestBody MallFreightTemplete mallFreightTemplete){
        try{
            MallFreightTemplete modifiedData =new MallFreightTemplete ();
            modifiedData.setTempleteId(mallFreightTemplete.getTempleteId());
            modifiedData.setStatus(DataStatusEnum.STATUS_DISABLE.getStatusValue());
            return  mallFreightTempleteService.updateMallFreightTempleteById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 删除标准运费
     * @param mallFreightTemplete
     * @return
     */
    @RequestMapping("/deleteMallFreightTemplete")
    public Result deleteMallFreightTemplete(@RequestBody MallFreightTemplete mallFreightTemplete){
        try{
            MallFreightTemplete modifiedData =new MallFreightTemplete ();
            modifiedData.setTempleteId(mallFreightTemplete.getTempleteId());
            modifiedData.setStatus(DataStatusEnum.STATUS_DELETED.getStatusValue());
            return  mallFreightTempleteService.updateMallFreightTempleteById(modifiedData);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回标准运费列表
     * @param queryMallFreightTemplete
     * @return
     */
    @RequestMapping("/findByPage")
    public  Result<List<MallFreightTemplete>> findByPage(@RequestBody QueryMallFreightTemplete queryMallFreightTemplete){
        return mallFreightTempleteService.getMallFreightTempletesByPage(queryMallFreightTemplete);
    }


    /**
     * 获取默认运费模板
     * @param queryMallFreightTemplete
     * @return
     */
    @RequestMapping("/findDefaultlFreightTemplete")
    public Result<MallFreightTemplete> findDefaultlFreightTemplete(@RequestBody  QueryMallFreightTemplete queryMallFreightTemplete){
        return mallFreightTempleteService.findDefaultlFreightTemplete(queryMallFreightTemplete);
    }

    @RequestMapping("/selectForFreightTemplete")
    public Result<List<AreaSelectedVo>> selectForFreightTemplete(@RequestBody  QueryMallFreightTemplete queryMallFreightTemplete){
        return  mallFreightTempleteService.selectForFreightTemplete(queryMallFreightTemplete);
    }
}
