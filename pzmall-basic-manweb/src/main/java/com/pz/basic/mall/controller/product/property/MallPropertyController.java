package com.pz.basic.mall.controller.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;
import com.pz.basic.mall.service.product.property.MallPropertyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 9:16
 */

@RestController
@RequestMapping("/property")
public class MallPropertyController {

    private MallPropertyService mallPropertyService;

    public void setMallPropertyService(MallPropertyService mallPropertyService) {
        this.mallPropertyService = mallPropertyService;
    }

    /**
     * 新增属性
     * @param mallProperty
     * @return
     */
    @RequestMapping("/addMallProperty")
    public Result<MallProperty>  addMallProperty(@RequestBody MallProperty mallProperty){
        try{
            return mallPropertyService.addMallProperty(mallProperty);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 修改属性
     * @param mallProperty
     * @return
     */
    @RequestMapping("/updateMallProperty")
    public Result updateMallProperty(@RequestBody MallProperty mallProperty){
        try{
            return mallPropertyService.updateMallPropertyById(mallProperty);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(false);
        }
    }


    /**
     * 分页返回属性列表
     * @param queryMallProperty
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallProperty>> findByPage(@RequestBody QueryMallProperty queryMallProperty){
        return mallPropertyService.getMallPropertysByPage(queryMallProperty);
    }

}
