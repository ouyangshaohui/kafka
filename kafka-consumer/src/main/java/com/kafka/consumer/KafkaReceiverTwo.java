package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @Author: oysh
 * @Date: 2019/5/5 22:51
 */
public class KafkaReceiverTwo {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  可同时监听多个topic
     * @param record
     * @throws Exception
     */
    @KafkaListener(topics = {"ttt"},groupId = "xiaofeng1")
    public void listen (ConsumerRecord<?, ?> record) throws Exception {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("消费者3开始消费message：" + message);
        }
    }
}
