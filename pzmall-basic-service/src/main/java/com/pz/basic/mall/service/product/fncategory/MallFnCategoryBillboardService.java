package com.pz.basic.mall.service.product.fncategory;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.fncategory.MallFnCategoryBillboard;
import com.pz.basic.mall.domain.product.fncategory.query.QueryMallFnCategoryBillboard;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/20 9:50
 */
public interface MallFnCategoryBillboardService {
    /**
     * 新增 mallFnCategoryBillboard
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到新增 mallFnCategoryBillboard
     * @param mallFnCategoryBillboard
     * @return
     */
    Result<MallFnCategoryBillboard> addMallFnCategoryBillboard(MallFnCategoryBillboard mallFnCategoryBillboard) ;

    /**
     * 按照主键id更新mallFnCategoryBillboard，请重新new MallFnCategoryBillboard 的更新对象，设置要更新的字段
     * 返回result，通过result.isSuccess()判断更新是否成功
     * @param mallFnCategoryBillboard
     * @return
     */
    Result updateMallFnCategoryBillboardById(MallFnCategoryBillboard mallFnCategoryBillboard);

    /**
     * 按照主键id 删除 记录
     * 返回result，通过result.isSuccess()判断删除是否成功
     * @param id
     * @return
     */
    Result deleteMallFnCategoryBillboardById(long id);

    /**
     * 查询列表，此接口不包含分页查询
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到列表信息
     * @param queryMallFnCategoryBillboard
     * @return
     */
    Result<List<MallFnCategoryBillboard>> getMallFnCategoryBillboardsByQuery(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard);

    /**
     * 通过主键id查询MallFnCategoryBillboard
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getModel()得到查询的单条mallFnCategoryBillboard信息
     * @param id
     * @return
     */
    Result<MallFnCategoryBillboard> getMallFnCategoryBillboardById(long id);

    /**
     * 查询列表，包含分页查询
     * 查询分页信息，请设置
     * QueryMallFnCategoryBillboard.setIndex(设置当前页数)
     * QueryMallFnCategoryBillboard.setPageSize(设置当前页面数据行数)
     * 返回result，通过result.isSuccess()判断服务调用是否成功
     * 通过result.getTotal()返回结果总数
     * 通过result.getModel()得到查询的单页列表信息
     * @param queryMallFnCategoryBillboard
     * @return
     */
    Result<List<MallFnCategoryBillboard>> getMallFnCategoryBillboardsByPage(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard);

    /**
     * 查询总数
     * @param queryMallFnCategoryBillboard
     * @return
     */
    Result<Long> count(QueryMallFnCategoryBillboard queryMallFnCategoryBillboard);

}
