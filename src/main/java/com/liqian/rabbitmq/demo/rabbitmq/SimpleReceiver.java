package com.liqian.rabbitmq.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = "simple_test")
@Component
public class SimpleReceiver {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.println("队列1收到的消息为:"+msg);
    }
}
