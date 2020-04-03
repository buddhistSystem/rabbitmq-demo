package com.liqian.rabbitmq.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 扇形交换机接收者B
 */
@RabbitListener(queues = "fanout.B")
@Component
public class FanoutReceiver2 {
    @RabbitHandler
    public void getMessage(String msg){
        System.out.println("fanout.B收到的消息为:"+msg);
    }
}
