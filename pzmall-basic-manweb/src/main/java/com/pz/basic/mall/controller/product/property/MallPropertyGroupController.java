package com.pz.basic.mall.controller.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyGroup;
import com.pz.basic.mall.service.product.property.MallPropertyGroupService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/2 8:04
 */

@RestController
@RequestMapping("/propertyGroup")
public class MallPropertyGroupController {

    private MallPropertyGroupService mallPropertyGroupService;

    public void setMallPropertyGroupService(MallPropertyGroupService mallPropertyGroupService) {
        this.mallPropertyGroupService = mallPropertyGroupService;
    }

    /**
     * 新增属性组
     * @param mallPropertyGroup
     * @return
     */
    @RequestMapping("/addMallPropertyGroup")
    public Result<MallPropertyGroup> addMallPropertyGroup(@RequestBody MallPropertyGroup mallPropertyGroup) {
        try {
            return mallPropertyGroupService.addMallPropertyGroup(mallPropertyGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 根据ID查找属性组
     * @param id
     * @return
     */
    @RequestMapping("/findMallPropertyGroupById")
    public Result<MallPropertyGroup> findMallPropertyGroupById(Long id) {
        return mallPropertyGroupService.getMallPropertyGroupById(id);
    }

    /**
     * 修改属性组
     * @param mallPropertyGroup
     * @return
     */
    @RequestMapping("/updateMallPropertyGroup")
    public Result updateMallPropertyGroup(@RequestBody MallPropertyGroup mallPropertyGroup) {
        try {
            return mallPropertyGroupService.updateMallPropertyGroupById(mallPropertyGroup);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false);
        }
    }

    /**
     * 分页返回属性组列表
     * @param queryMallPropertyGroup
     * @return
     */
    @RequestMapping("/findByPage")
    public Result<List<MallPropertyGroup>> findByPage(@RequestBody QueryMallPropertyGroup queryMallPropertyGroup) {
        System.out.println("/propertyGroup/findByPage");
        return mallPropertyGroupService.getMallPropertyGroupByPage(queryMallPropertyGroup);
    }

    /**
     * 返回所有启用状态的属性组列表
     * @param queryMallPropertyGroup
     * @return
     */
    @RequestMapping("/findAll")
    public Result<List<MallPropertyGroup>> findAll(@RequestBody QueryMallPropertyGroup queryMallPropertyGroup) {
        queryMallPropertyGroup.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
        return mallPropertyGroupService.getMallPropertyGroupsByQuery(queryMallPropertyGroup);
    }
}
