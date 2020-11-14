package com.pz.basic.mall.service.product.category;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.product.category.MallCategory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author percy
 * @date 2020/9/18 9:24
 */
public class TestMallCategroyService {

    @Test
    public void testAddMallCategory() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallCategoryService service = (MallCategoryService) ac.getBean("mallCategoryService");
        MallCategory mallCategory = new MallCategory();
        mallCategory.setCategoryName("手机");
        mallCategory.setCreateUser("percy");
        mallCategory.setLevel(1);
        mallCategory.setFeatures("包括功能手机和只能手机");
        mallCategory.setNotes("所有的手机都包括在内");
        mallCategory.setSortOrder(1);
        Result<MallCategory> result = service.addMallCategory(mallCategory);
        System.out.println(result.isSuccess() + result.getMessage());
    }
}
