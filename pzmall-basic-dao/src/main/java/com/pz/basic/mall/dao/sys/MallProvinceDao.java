package com.pz.basic.mall.dao.sys;

import com.pz.basic.mall.domain.sys.MallProvince;
import com.pz.basic.mall.domain.sys.query.QueryMallProvince;

import java.util.List;

/**
 * @author percy
 * @date 2020/8/28 15:35
 */
public interface MallProvinceDao {

    /**
     * 根据条件查询总数
     * @param query
     * @return
     */
    long countByQuery(QueryMallProvince query);

    /**
     * 根据条件删除记录
     * @param query
     * @return
     */
    int deleteMallProvinceByQuery(QueryMallProvince query);

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteMallProvinceById(long id);

    /**
     * 新增记录
     * @param record
     * @return
     */
    long insertMallProvince(MallProvince record);

    /**
     * 新增记录 注意：有值的记录才新增
     * @param record
     * @return
     */
    long insertMallProvinceModified(MallProvince record);

    /**
     * 根据查询条件返回列表
     * @param query
     * @return
     */
    List<MallProvince> selectMallProvinceByQuery(QueryMallProvince query);

    /**
     * 根据查询条件返回列表
     * @param  query
     * @return
     */
    List<MallProvince> selectMallProvinceByPage(QueryMallProvince query);

    /**
     * 根据ID查询对象
     * @param id
     * @return
     */
    MallProvince selectMallProvinceById(long id);


    /**
     * 根据id修改记录 注意：有值的字段才更新
     * @param record
     * @return
     */
    int updateMallProvinceByIdModified(MallProvince record);
}
