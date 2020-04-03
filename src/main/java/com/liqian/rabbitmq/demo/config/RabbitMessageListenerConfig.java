package com.liqian.rabbitmq.demo.config;


import com.liqian.rabbitmq.demo.config.RabbitMqTestConfig;
import com.liqian.rabbitmq.demo.rabbitmq.AckReceiver;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * rabbitmq接收消息手动确认配置类
 */
@Configuration
public class RabbitMessageListenerConfig {



    @Resource
    private CachingConnectionFactory connectionFactory;
    @Resource
    private AckReceiver ackReceiver;//Direct消息接收处理类
    //    @Autowired
    //    FanoutReceiver fanoutReceiver;//Fanout消息接收处理类A
    @Resource
    RabbitMqTestConfig rabbitMqTestConfig;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setQueues(rabbitMqTestConfig.TestDirectQueue());
        container.setMessageListener(ackReceiver);
        //        container.addQueues(rabbitMqTestConfig.queueA());
        //        container.setMessageListener(fanoutReceiver);
        return container;

    }

}
