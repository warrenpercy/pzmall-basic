package com.pz.basic.mall.dao.product.property;

import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyGroup;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:38
 */
public interface MallPropertyGroupDao {

    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallPropertyGroup query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallPropertyGroupByQuery(QueryMallPropertyGroup query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallPropertyGroupById(long id);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallPropertyGroupModified(MallPropertyGroup record);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallPropertyGroup(MallPropertyGroup record);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallPropertyGroup selectMallPropertyGroupById(long id);

    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallPropertyGroupByIdModified(MallPropertyGroup record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallPropertyGroup> selectMallPropertyGroupByPage(QueryMallPropertyGroup query);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallPropertyGroup> selectMallProperytGroupByQuery(QueryMallPropertyGroup query);
}
