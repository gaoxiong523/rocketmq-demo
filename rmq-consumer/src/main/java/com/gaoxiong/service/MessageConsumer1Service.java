package com.gaoxiong.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author gaoxiong
 * @ClassName MessageService
 * @Description TODO
 * @date 2019/7/30 11:56
 */
@Service
@Slf4j
@RocketMQMessageListener(topic = "test-topic-1",consumerGroup = "my-consumer_test-topic-1")
public class MessageConsumer1Service implements RocketMQListener<String> {


    @Override
    public void onMessage ( String s ) {
        log.info(s);
    }
}
