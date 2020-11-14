package com.pz.basic.mall.dao.sys;

import com.pz.basic.mall.domain.sys.MallBrand;
import com.pz.basic.mall.domain.sys.query.QueryMallBrand;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/21 10:14
 */

public interface MallBrandDao {
    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallBrand query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallBrandByQuery(QueryMallBrand query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallBrandById(long id);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallBrand(MallBrand record);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallBrandModified(MallBrand record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallBrand> selectMallBrandByQuery(QueryMallBrand query);

    /**
     * 根据查询条件返回列表
     * @param  query
     * @return
     */
    List<MallBrand> selectMallBrandByPage(QueryMallBrand query);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallBrand selectMallBrandById(long id);


    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallBrandByIdModified(MallBrand record);
}
