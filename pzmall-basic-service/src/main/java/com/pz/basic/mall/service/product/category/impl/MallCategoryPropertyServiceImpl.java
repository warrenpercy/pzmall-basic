package com.pz.basic.mall.service.product.category.impl;

import com.pz.basic.mall.dao.product.category.MallCategoryPropertyDao;
import com.pz.basic.mall.dao.product.category.MallCategoryPropertyValueDao;
import com.pz.basic.mall.dao.product.property.MallPropertyDao;
import com.pz.basic.mall.dao.product.property.MallPropertyGroupDao;
import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.base.enums.DataStatusEnum;
import com.pz.basic.mall.domain.product.category.MallCategoryPropertyValue;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryPropertyValue;
import com.pz.basic.mall.domain.product.property.MallProperty;
import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.query.QueryMallProperty;
import com.pz.basic.mall.domain.product.property.query.QueryMallPropertyGroup;
import com.pz.basic.mall.domain.product.property.vo.MallCategoryPropertyValueVo;
import com.pz.basic.mall.domain.product.property.vo.MallCategoryPropertyVo;
import com.pz.basic.mall.domain.product.property.vo.MallGroupVo;
import com.pz.basic.mall.domain.product.category.query.QueryMallCategoryProperty;
import com.pz.basic.mall.service.product.category.MallCategoryPropertyService;
import org.springframework.util.CollectionUtils;
import com.pz.basic.mall.domain.product.category.MallCategoryProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author percy
 * @date 2020/9/19 15:02
 */
public class MallCategoryPropertyServiceImpl implements MallCategoryPropertyService {

    private static final Long UnsignedGroupId = 0L;
    private static final String UnsignedGroupName = "未分组";

    private MallPropertyDao mallPropertyDao;
    private MallCategoryPropertyDao mallCategoryPropertyDao;
    private MallPropertyGroupDao mallPropertyGroupDao;
    private MallCategoryPropertyValueDao mallCategoryPropertyValueDao;

    public void setMallPropertyGroupDao(MallPropertyGroupDao mallPropertyGroupDao) {
        this.mallPropertyGroupDao = mallPropertyGroupDao;
    }

    public void setMallCategoryPropertyDao(MallCategoryPropertyDao mallCategoryPropertyDao) {
        this.mallCategoryPropertyDao = mallCategoryPropertyDao;
    }

    public void setMallPropertyDao(MallPropertyDao mallPropertyDao) {
        this.mallPropertyDao = mallPropertyDao;
    }

    @Override
    public Result<List<MallGroupVo>> getMallPropertyGroup(QueryMallProperty queryMallProperty) {
        Result<List<MallGroupVo>> result = new Result<List<MallGroupVo>>();
        QueryMallPropertyGroup groupQuery = new QueryMallPropertyGroup();
        groupQuery.setGroupNameLike(queryMallProperty.getPropertyNameLike());
        List<MallPropertyGroup> groupList = getGroupList(groupQuery);
        if (!CollectionUtils.isEmpty(groupList)) {
            List<Long> idList = groupList.stream().map(e -> e.getGroupId()).collect(Collectors.toList());
            queryMallProperty.setGroupIdList(idList);
        }
        List<MallProperty> propertyList = mallPropertyDao.selectMallPropertyByQuery(queryMallProperty);
        List<Long> shieldIdList = getShieldPropertyIdList(queryMallProperty);

        //删除需要屏蔽的对象
        if (!CollectionUtils.isEmpty(shieldIdList)) {
            propertyList.removeIf(a -> {
               return shieldIdList.stream().anyMatch(b -> {
                   return b != null && b.equals(a.getPropertyId());
               });
            });
        }
        List<MallGroupVo> dataList = getMallGroupVoList(propertyList, groupList);
        result.addDefaultModel(dataList);
        return result;
    }

    @Override
    public Result<List<MallCategoryProperty>> addMallCategoryPropertyBatch(List<MallCategoryProperty> mallCategoryPropertyList) {
        Result<List<MallCategoryProperty>> result = new Result<List<MallCategoryProperty>>();
        List<MallCategoryProperty> modelList = new ArrayList<MallCategoryProperty>();
        try {
            for (MallCategoryProperty mcp : mallCategoryPropertyList) {
                QueryMallCategoryProperty query = new QueryMallCategoryProperty();
                query.setPropertyName(mcp.getPropertyName());
                long count = mallCategoryPropertyDao.countByQuery(query);
                if (count > 0) {
                    result.setSuccess(false);
                    result.setMessage(mcp.getPropertyName() + "属性已经在属性组中");
                    continue;
                }
                mcp.setStatus(DataStatusEnum.STATUS_ENABLE.getStatusValue());
                mallCategoryPropertyDao.insertMallCategoryProperty(mcp);
                modelList.add(mcp);
            }
            result.addDefaultModel(modelList);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result updateMallCategoryPropertyById(MallCategoryProperty mallCategoryProperty) {
        Result result = new Result();
        try {
            int count = mallCategoryPropertyDao.updateMallCategoryPropertyByIdModified(mallCategoryProperty);
            if (count > 0) {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public Result<List<MallCategoryProperty>> getMallCategoryPropertysByPage(QueryMallCategoryProperty queryMallCategoryProperty) {
        Result<List<MallCategoryProperty>> result = new Result<List<MallCategoryProperty>>();
        long totalItem = mallCategoryPropertyDao.countByQuery(queryMallCategoryProperty);
        queryMallCategoryProperty.setTotalItem(totalItem);
        queryMallCategoryProperty.repaginate();
        if (totalItem > 0) {
            result.addDefaultModel(mallCategoryPropertyDao.selectMallCategoryPropertyByPage(queryMallCategoryProperty));
        } else {
            result.addDefaultModel(new ArrayList<MallCategoryProperty>());
        }
        result.setTotalItem(totalItem);
        result.setPageSize(queryMallCategoryProperty.getPageSize());
        result.setPage(queryMallCategoryProperty.getPage());
        return result;
    }

    @Override
    public Result<List<MallCategoryPropertyVo>> findForReleaseProduct(QueryMallCategoryProperty queryMallCategoryProperty) {
        Result<List<MallCategoryPropertyVo>> result = new Result<List<MallCategoryPropertyVo>>();
        List<MallCategoryProperty> propertyList=mallCategoryPropertyDao.selectMallCategoryPropertyByQuery(queryMallCategoryProperty);

        QueryMallCategoryPropertyValue queryValue = new QueryMallCategoryPropertyValue();
        queryValue.setCategoryIdList(queryMallCategoryProperty.getCategoryIdList());

        List<MallCategoryPropertyValue> valueList = mallCategoryPropertyValueDao.selectMallCategoryPropertyValueByQuery(queryValue);
        result.addDefaultModel(buildMallCategoryPropertyVoList(propertyList, valueList));
        return result;
    }

    private List<MallCategoryPropertyVo> buildMallCategoryPropertyVoList(List<MallCategoryProperty> propertyList,List<MallCategoryPropertyValue> valueList) {
        List<MallCategoryPropertyVo> dataList = new ArrayList<MallCategoryPropertyVo>();
        for (MallCategoryProperty property : propertyList) {

            MallCategoryPropertyVo propertyVo = new MallCategoryPropertyVo();
            propertyVo.setId(property.getCategoryPropertyId());
            propertyVo.setName(property.getPropertyName());
            propertyVo.setPropertyType(property.getPropertyType());
            for (MallCategoryPropertyValue value : valueList) {
                if (property.getCategoryPropertyId().longValue() == value.getCategoryPropertyId().longValue()) {
                    MallCategoryPropertyValueVo valueVo = new MallCategoryPropertyValueVo();
                    valueVo.setId(value.getCategoryPropertyValueId());
                    valueVo.setName(value.getPropertyValueData());
                    propertyVo.getValueList().add(valueVo);
                    dataList.add(propertyVo);
                }

            }

        }
        return dataList;
    }

    private List<MallGroupVo> getMallGroupVoList(List<MallProperty> propertyList, List<MallPropertyGroup> groupList ) {
        Map<Long, MallGroupVo> groupMap = new HashMap<Long, MallGroupVo>();
        List<MallGroupVo> dataList = new ArrayList<MallGroupVo>();
        MallGroupVo group= null;
        MallPropertyGroup mallGroup = null;
        if (!CollectionUtils.isEmpty(propertyList)) {
            for (MallProperty property : propertyList) {
                mallGroup = getMallPropertyGroup(groupList, property.getGroupId());
                if (null == mallGroup) {
                    group = groupMap.get(UnsignedGroupId);
                } else {
                    group = groupMap.get(property.getGroupId());
                }
                if (null == group) {
                    List<MallGroupVo> list = new ArrayList<MallGroupVo>();
                    List<MallProperty> dbList = new ArrayList<MallProperty>();
                    dbList.add(property);
                    group = new MallGroupVo();
                    list.add(group);
                    if (null == mallGroup) {
                        group.setId(UnsignedGroupId);
                        group.setLabel(UnsignedGroupName);
                    } else {
                        group.setId(mallGroup.getGroupId());
                        group.setLabel(mallGroup.getGroupName());
                    }
                    group.setChildren(dbList);
                    groupMap.put(group.getId(), group);
                } else {
                    group.getChildren().add(property);
                }
            }
        }
        if (!CollectionUtils.isEmpty(groupMap)) {
            dataList.addAll(groupMap.values());
        }
        return dataList;
    }

    /**
     * 获取需要屏蔽的对象
     * @param queryMallProperty
     * @return
     */
    private List<Long> getShieldPropertyIdList(QueryMallProperty queryMallProperty) {
        List<Long> catIdList = new ArrayList<Long>();
        if (null != queryMallProperty.getCatOneId()) {
            catIdList.add(queryMallProperty.getCatOneId());
        }
        if (null != queryMallProperty.getCatTwoId()) {
            catIdList.add(queryMallProperty.getCatTwoId());
        }
        if (null != queryMallProperty.getCatThreeId()) {
            catIdList.add(queryMallProperty.getCatThreeId());
        }

        if (!CollectionUtils.isEmpty(catIdList)) {
            QueryMallCategoryProperty query = new QueryMallCategoryProperty();
            query.setCategoryIdList(catIdList);
            List<MallCategoryProperty> dataList = mallCategoryPropertyDao.selectMallCategoryPropertyByQuery(query);
            List<Long> shieldList = dataList.stream().map(e -> e.getPropertyId()).collect(Collectors.toList());
            return shieldList;
        }
        return null;
    }

    private List<MallPropertyGroup> getGroupList(QueryMallPropertyGroup groupQuery) {
        return mallPropertyGroupDao.selectMallProperytGroupByQuery(groupQuery);
    }

    private MallPropertyGroup getMallPropertyGroup(List<MallPropertyGroup> groupList, Long groupId) {
        for (MallPropertyGroup group : groupList) {
            if (groupId.equals(group.getGroupId())) {
                return group;
            }
        }
        return null;
    }
}
