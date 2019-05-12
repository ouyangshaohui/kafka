package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: oysh
 * @Date: 2019/5/5 22:48
 */
@Component
public class KafkaReceiver {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  可同时监听多个topic 测试失败只在一个类里
     * @param record
     * @throws Exception
     */
    @KafkaListener(topics = {"hhh"},groupId = "xiaofeng1")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者1开始消费message：" + message);
        }
    }
    @KafkaListener(topics = {"xxx"},groupId = "xiaofeng2")
    public void listen2 (ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者2开始消费message：" + message);
        }
    }
}
