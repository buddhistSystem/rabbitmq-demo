package com.liqian.rabbitmq.demo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Send {

    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * 测试直连型交换机
     */
    @RequestMapping("send1")
    public void sendMessage(){
        amqpTemplate.convertAndSend("simple_test_exchange", "simple_test", "hello queue1");
        System.out.println("send over");
    }
    /**
     * 测试直连型交换机
     */
    @RequestMapping("send2")
    public void sendMessage2(){
        amqpTemplate.convertAndSend("simple_test_exchange2", "simple_test2", "hello queue2");
        System.out.println("send over");
    }

    /**
     * 测试扇形型交换机
     */
    @RequestMapping("/send3")
    public void sendFanoutMessage() {
        amqpTemplate.convertAndSend("fanoutExchange", null, "hello i am fanout");
        System.out.println("send over");
    }

    /**
     * 测试消费端手动确认
     */
    @RequestMapping("/send4")
    public void sendAckMessage() {
        amqpTemplate.convertAndSend("test_direct_exchange", "test_direct_queue", "hello i am ack");
        System.out.println("send over");
    }
}
