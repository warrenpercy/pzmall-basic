package com.pz.basic.mall.service.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallBrand;
import com.pz.basic.mall.domain.sys.query.QueryMallBrand;

import java.util.List;

/**
 * service层，组装外部接口和 本地业务，为本业务 或者其他业务提供服务，统一返回Result
 * 通过Result.isSuccess判断调用是否成功
 * 此类中新增业务接口设计（接口命令，入参数据，返回值）要能尽量完整的表达业务 含义
 * @author percy
 * @date 2020/8/21 10:35
 */
public interface MallBrandService {
    /**
     * 新增 mallBrand
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增mallBrand
     * @param mallBrand
     * @return
     */
    Result<MallBrand> addMallBrand(MallBrand mallBrand) ;

    /**
     * 按照主键id更新mallBrand，请重新new MallBrand 的更新对象，设置要更新的字段
     * 返回result，通过result.isSuccess()判断更新是否成功
     * @param mallBrand
     * @return
     */
    Result updateMallBrandById(MallBrand mallBrand);

    /**
     * 按照主键id 删除 记录
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @return
     */
    Result deleteMallBrandById(MallBrand mallBrand);

    /**
     * 查询列表，此接口不包含分页查询
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param queryMallBrand
     * @return
     */
    Result<List<MallBrand>> getMallBrandsByQuery(QueryMallBrand queryMallBrand);

    /**
     * 通过主键id查询MallBrand
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到查询的单条mallBrand信息
     * @param id
     * @return
     */
    Result<MallBrand> getMallBrandById(long id);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * QueryMallBrand.setIndex(设置当前页数)
     *QueryMallBrand.setPageSize(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param queryMallBrand
     * @return
     */
    Result<List<MallBrand>> getMallBrandsByPage(QueryMallBrand queryMallBrand);

    /**
     * 查询总数
     * @param queryMallBrand
     * @return
     */
    Result<Long> count(QueryMallBrand queryMallBrand);

    /**
     * 停用启用品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param brandList
     * @param disable true 停用 false 启用
     * @return
     */
    Result disableEnableMallBrandList(List<MallBrand> brandList, boolean disable);

    /**
     * 逻辑删除品牌列表
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param brandList
     * @return
     */
    Result deleteMallBrandList(List<MallBrand> brandList);
}
