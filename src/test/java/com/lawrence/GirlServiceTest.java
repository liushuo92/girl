package com.lawrence;

import com.lawrence.domain.Girl;
import com.lawrence.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liush
 * 2018/8/22   3:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(1);
        Assert.assertEquals(new Integer(18),girl.getAge());
        Assert.assertEquals("B",girl.getCupSize());
    }
}
