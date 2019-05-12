package com.kafka.producer;

/**
 * @Author: oysh
 * @Date: 2019/5/5 22:41
 */
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * kafka生产者
 */
@Component
public class KafkaSender {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //发送消息方法
    public void send(String topic) {
        JSONObject obj=new JSONObject();
        obj.put("id",System.currentTimeMillis());
        obj.put("name","生产者发送消息");
        obj.put("date",new Date());
        logger.info("+++++++++++++++++++++  message = {}", gson.toJson(obj));
        kafkaTemplate.send(topic, gson.toJson(obj));
    }
}
