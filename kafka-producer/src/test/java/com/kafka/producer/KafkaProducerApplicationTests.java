package com.kafka.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaProducerApplicationTests {
    @Autowired
    private KafkaSender producer;
    @Test
    public void contextLoads() {
            producer.send("hhh");
            producer.send("xxx");
            //同项目不同类不行
            producer.send("ttt");
            //不同项目里可以
            producer.send("test");


    }

}
