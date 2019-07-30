package com.gaoxiong.service;

import com.gaoxiong.pojo.OrderPaidEvent;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author gaoxiong
 * @ClassName SendMessage
 * @Description TODO
 * @date 2019/7/30 11:41
 */
@Service
public class SendMessageService {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendMsg(){
        rocketMQTemplate.convertAndSend("test-topic-1", "helloworld");
        rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("helloworld,i am from spring").build());
        rocketMQTemplate.convertAndSend("test-topic-2", new OrderPaidEvent("T-001", new BigDecimal("88.00")));

    }

}
