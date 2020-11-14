package com.pz.basic.mall.service.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallBrand;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author percy
 * @date 2020/8/22 14:47
 */
public class TestMallBrandService {

    @Test
    public void testGetMallBrandById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallBrandService mallBrandService = (MallBrandService) applicationContext.getBean("mallBrandService");
        Result<MallBrand> mallBrandById = mallBrandService.getMallBrandById(1L);
        MallBrand mallBrand = mallBrandById.getModel();
        System.out.println(mallBrand.getId() + ":" + mallBrand.getBrandName());
    }

    @Test
    public void testaddMallBrand(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallBrandService mallBrandService = (MallBrandService) applicationContext.getBean("mallBrandService");
        MallBrand mallBrand = new MallBrand();
        mallBrand.setBrandName("brandname002");
        mallBrand.setFirstChar("b");
        mallBrand.setStatus(1);
        mallBrand.setActive(1);
        mallBrand.setLogo("brandname002.jpg");
        Result<MallBrand> mallBrandResult = mallBrandService.addMallBrand(mallBrand);
        System.out.println(mallBrandResult.getMessage());

    }
}
