package com.liqian.rabbitmq.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 扇形交换机接收者A
 */
@RabbitListener(queues = "fanout.A")
@Component
public class FanoutReceiver {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.println("fanout.A收到的消息为:"+msg);
    }
}
