package com.ian.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.ian")
public class UserAppApplicationIT {

    @Test
    public void contextLoads() {
        UserAppApplication.main(new String[]{});
    }
}