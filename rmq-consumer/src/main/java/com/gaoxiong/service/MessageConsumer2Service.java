package com.gaoxiong.service;

import com.gaoxiong.pojo.OrderPaidEvent;
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
@RocketMQMessageListener(topic = "test-topic-2",consumerGroup = "my-consumer_test-topic-2")
public class MessageConsumer2Service implements RocketMQListener<OrderPaidEvent> {


    @Override
    public void onMessage ( OrderPaidEvent orderPaidEvent ) {
        //保证消息的幂等性
        //1.获得订单id,或者支付流水id
        String orderId = orderPaidEvent.getOrderId();
        //2.去缓存中查询是否有值, 如果有值,说明已经支付过了,(当然支付结果可以不在这个逻辑处理)
        //返回提示信息给前端用户,
        //3.如果没有值,继续进行支付处理,处理完毕,给缓存中设置以流水号 为 key 的 值(任意值,只是为了标示,当前消息消费过了)

        log.info("received orderPaidEvent: {}", orderPaidEvent);
        log.info(orderPaidEvent.getOrderId());
        log.info(String.valueOf(orderPaidEvent.getPaidMoney()));
    }
}
