package org.csu.demo;

import org.csu.demo.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private DataSource dataSource;


    @Test
    public void contextLoads() {
        try{
            Connection connection=dataSource.getConnection();
            System.out.println(".................."+connection+"..................");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
