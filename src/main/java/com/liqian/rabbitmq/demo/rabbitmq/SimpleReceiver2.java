package com.liqian.rabbitmq.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "simple_test2")
@Component
public class SimpleReceiver2 {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.println("队列2收到的消息为:"+msg);
    }
}
