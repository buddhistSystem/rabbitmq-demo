package com.liqian.rabbitmq.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mq的测试配置
 */
@Configuration
public class RabbitMqTestConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue("simple_test");
    }

    @Bean
    public Queue simpleQueue2() {
        return new Queue("simple_test2");
    }

    @Bean
    DirectExchange simpleDirectExchange() {
        return (DirectExchange) ExchangeBuilder
                .directExchange("simple_test_exchange")
                .durable(true)
                .build();
    }

    @Bean
    DirectExchange simpleDirectExchange2() {
        return (DirectExchange) ExchangeBuilder
                .directExchange("simple_test_exchange2")
                .durable(true)
                .build();
    }

    @Bean
    Binding simpleBinding(DirectExchange simpleDirectExchange, Queue simpleQueue) {
        return BindingBuilder
                .bind(simpleQueue)
                .to(simpleDirectExchange)
                .with("simple_test");
    }

    @Bean
    Binding simpleBinding2(DirectExchange simpleDirectExchange2, Queue simpleQueue2) {
        return BindingBuilder
                .bind(simpleQueue2)
                .to(simpleDirectExchange2)
                .with("simple_test2");
    }

    /**
     * 以下测试扇形交换机
     */
    @Bean
    public Queue queueA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueB() {
        return new Queue("fanout.B");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }


    /**
     * 以下测试消费者手动确认
     */
    @Bean
    public Queue TestDirectQueue() {
        return new Queue("test_direct_queue");
    }

    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("test_direct_exchange");
    }

    @Bean
    Binding bindingTestDirectExchange() {
        return BindingBuilder
                .bind(TestDirectQueue())
                .to(TestDirectExchange())
                .with("test_direct_queue");
    }

}
