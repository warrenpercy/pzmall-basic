package com.pz.basic.mall.dao.sys;

import com.pz.basic.mall.domain.sys.MallArea;
import com.pz.basic.mall.domain.sys.query.QueryMallArea;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:39
 */
public interface MallAreaDao {
    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallArea query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallAreaByQuery(QueryMallArea query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallAreaById(long id);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallArea(MallArea record);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallAreaModified(MallArea record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallArea> selectMallAreaByQuery(QueryMallArea query);

    /**
     * 根据查询条件返回列表
     * @param  query
     * @return
     */
    List<MallArea> selectMallAreaByPage(QueryMallArea query);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallArea selectMallAreaById(long id);


    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallAreaByIdModified(MallArea record);
}
