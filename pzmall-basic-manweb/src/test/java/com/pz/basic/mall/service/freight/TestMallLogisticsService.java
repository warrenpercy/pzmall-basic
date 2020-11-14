package com.pz.basic.mall.service.freight;

import com.pz.basic.mall.domain.base.Result;
import com.pz.basic.mall.domain.freight.MallLogistics;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author percy
 * @date 2020/9/22 8:41
 */
public class TestMallLogisticsService {

    @Test
    public void testAddMallLogistics() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
        MallLogisticsService mls = (MallLogisticsService) ap.getBean("mallLogisticsService");
        MallLogistics record = new MallLogistics();
        record.setLogisticsName("测试快递");
        record.setCreateUser("percy");
        record.setLogisticsCode(1234567890987654321L);
        Result<MallLogistics> result = mls.addMallLogistics(record);
        System.out.println(result.isSuccess() + result.getMessage());
    }
}
