package com.pz.basic.mall.dao.sys;

import com.pz.basic.mall.domain.sys.MallCity;
import com.pz.basic.mall.domain.sys.query.QueryMallCity;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:38
 */
public interface MallCityDao {
    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallCity query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallCityByQuery(QueryMallCity query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallCityById(long id);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallCity(MallCity record);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallCityModified(MallCity record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallCity> selectMallCityByQuery(QueryMallCity query);

    /**
     * 根据查询条件返回列表
     * @param  query
     * @return
     */
    List<MallCity> selectMallCityByPage(QueryMallCity query);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallCity selectMallCityById(long id);


    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallCityByIdModified(MallCity record);
}
