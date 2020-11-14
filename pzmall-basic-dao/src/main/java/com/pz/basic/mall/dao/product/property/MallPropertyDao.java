package com.pz.basic.mall.dao.product.property;

import com.pz.basic.mall.domain.product.property.MallProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;

import java.util.List;

/**
 * @author percy
 * @date 2020/9/16 7:38
 */
public interface MallPropertyDao {
    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallProperty query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallPropertyByQuery(QueryMallProperty query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallPropertyById(long id);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallPropertyModified(MallProperty record);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallProperty(MallProperty record);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallProperty selectMallPropertyById(long id);

    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallPropertyByIdModified(MallProperty record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallProperty> selectMallPropertyByPage(QueryMallProperty query);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallProperty> selectMallPropertyByQuery(QueryMallProperty query);
}
