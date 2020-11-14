package com.pz.basic.mall.dao.product.property;

import com.pz.basic.mall.domain.product.property.MallPropertyValue;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyValue;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:39
 */
public interface MallPropertyValueDao {
    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallPropertyValue query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallPropertyValueByQuery(QueryMallPropertyValue query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallPropertyValueById(long id);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallPropertyValueModified(MallPropertyValue record);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallPropertyValue(MallPropertyValue record);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallPropertyValue selectMallPropertyValueById(long id);

    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallPropertyValueByIdModified(MallPropertyValue record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallPropertyValue> selectMallPropertyValueByPage(QueryMallPropertyValue query);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallPropertyValue> selectMallProperytValueByQuery(QueryMallPropertyValue query);
}
