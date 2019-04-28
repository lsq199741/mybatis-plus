package org.luo.mybatisplus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.luo.mybatisplus.utils.MD5Utils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println(MD5Utils.getMd5("123456"));
    }

}
