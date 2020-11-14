package com.pz.basic.mall.service.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallArea;
import com.pz.basic.mall.domain.sys.query.QueryMallArea;

import java.util.List;

/**
 * service层，组装外部接口和 本地业务，为本业务 或者其他业务提供服务，统一返回Result
 * 通过Result.isSuccess判断调用是否成功
 * 此类中新增业务接口设计（接口命令，入参数据，返回值）要能尽量完整的表达业务 含义
 * @author percy
 * @date 2020/8/28 16:09
 */
public interface MallAreaService {
    /**
     * 新增 mallArea
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增mallArea
     * @param mallArea
     * @return
     */
    Result<MallArea> addMallArea(MallArea mallArea) ;

    /**
     * 按照主键id更新mallArea，请重新new MallArea 的更新对象，设置要更新的字段
     * 返回result，通过result.isSuccess()判断更新是否成功
     * @param mallArea
     * @return
     */
    Result updateMallAreaById(MallArea mallArea);

    /**
     * 按照主键id 删除 记录
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @return
     */
    Result deleteMallAreaById(MallArea mallArea);

    /**
     * 查询列表，此接口不包含分页查询
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param queryMallArea
     * @return
     */
    Result<List<MallArea>> getMallAreasByQuery(QueryMallArea queryMallArea);

    /**
     * 通过主键id查询MallArea
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到查询的单条mallArea信息
     * @param id
     * @return
     */
    Result<MallArea> getMallAreaById(long id);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * QueryMallArea.setIndex(设置当前页数)
     *QueryMallArea.setPageSize(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param queryMallArea
     * @return
     */
    Result<List<MallArea>> getMallAreasByPage(QueryMallArea queryMallArea);

    /**
     * 查询总数
     * @param queryMallArea
     * @return
     */
    Result<Long> count(QueryMallArea queryMallArea);

    /**
     * 停用启用品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param areaList
     * @param disable true 停用 false 启用
     * @return
     */
    Result disableEnableMallAreaList(List<MallArea> areaList, boolean disable);

    /**
     * 逻辑删除品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param areaList
     * @return
     */
    Result deleteMallAreaList(List<MallArea> areaList);
}
