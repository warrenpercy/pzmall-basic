package com.pz.basic.mall.service.sys;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.sys.MallProvince;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author percy
 * @date 2020/9/15 15:45
 */
public class TestMallProvinceService {

    @Test
    public void testAddMallProvince(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallProvinceService mallProvinceService = (MallProvinceService) applicationContext.getBean("mallProvinceService");
        MallProvince mallProvince = new MallProvince();
        mallProvince.setId(1L);
        mallProvince.setProvinceName("浙江");
        mallProvince.setProvinceId("浙");
        mallProvince.setStatus(1);
        Result<MallProvince> mallProvinceResult = mallProvinceService.addMallProvince(mallProvince);
        System.out.println(mallProvinceResult.isSuccess());

    }
}
