package com.pz.basic.mall.service.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallCity;
import com.pz.basic.mall.domain.sys.query.QueryMallCity;

import java.util.List;

/**
 * service层，组装外部接口和 本地业务，为本业务 或者其他业务提供服务，统一返回Result
 * 通过Result.isSuccess判断调用是否成功
 * 此类中新增业务接口设计（接口命令，入参数据，返回值）要能尽量完整的表达业务 含义
 * @author percy
 * @date 2020/8/28 16:09
 */
public interface MallCityService {

    /**
     * 新增 mallCity
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增mallCity
     * @param mallCity
     * @return
     */
    Result<MallCity> addMallCity(MallCity mallCity) ;

    /**
     * 按照主键id更新mallCity，请重新new MallCity 的更新对象，设置要更新的字段
     * 返回result，通过result.isSuccess()判断更新是否成功
     * @param mallCity
     * @return
     */
    Result updateMallCityById(MallCity mallCity);

    /**
     * 按照主键id 删除 记录
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @return
     */
    Result deleteMallCityById(MallCity mallCity);

    /**
     * 查询列表，此接口不包含分页查询
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param queryMallCity
     * @return
     */
    Result<List<MallCity>> getMallCitysByQuery(QueryMallCity queryMallCity);

    /**
     * 通过主键id查询MallCity
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到查询的单条mallCity信息
     * @param id
     * @return
     */
    Result<MallCity> getMallCityById(long id);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * QueryMallCity.setIndex(设置当前页数)
     *QueryMallCity.setPageSize(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param queryMallCity
     * @return
     */
    Result<List<MallCity>> getMallCitysByPage(QueryMallCity queryMallCity);

    /**
     * 查询总数
     * @param queryMallCity
     * @return
     */
    Result<Long> count(QueryMallCity queryMallCity);

    /**
     * 停用启用品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param cityList
     * @param disable true 停用 false 启用
     * @return
     */
    Result disableEnableMallCityList(List<MallCity> cityList, boolean disable);

    /**
     * 逻辑删除品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param cityList
     * @return
     */
    Result deleteMallCityList(List<MallCity> cityList);
}
