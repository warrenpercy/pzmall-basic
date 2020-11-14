package com.pz.basic.mall.service.product.property;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.property.MallPropertyGroup;
import com.pz.basic.mall.domain.product.property.MallPropertyValue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author percy
 * @date 2020/9/16 9:27
 */
public class TestMallPropertyGroupService {

    @Test
    public void testAddMallPropertyGroup() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallPropertyGroupService mpgservice = (MallPropertyGroupService) ac.getBean("mallPropertyGroupService");
        MallPropertyGroup mpg = new MallPropertyGroup();
        mpg.setGroupId(1L);
        mpg.setGroupName("外观");
        mpg.setGroupType(1);
        mpg.setSortOrder(1);
        mpg.setStatus(1);
        Result<MallPropertyGroup> result = mpgservice.addMallPropertyGroup(mpg);
        System.out.println(result.isSuccess() + result.getMessage());
    }

    @Test
    public void testGetMallPropertyGroupById() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallPropertyGroupService mpgservice = (MallPropertyGroupService) ac.getBean("mallPropertyGroupService");
        Result<MallPropertyGroup> result = mpgservice.getMallPropertyGroupById(1L);
        System.out.println(result.getModel());
    }
}
