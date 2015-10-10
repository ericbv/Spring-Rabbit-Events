package com.example;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Eric on 10/9/2015.
 */
@Configuration
public class GlobalRabbitConfiguration {

    public static final String FirstConsumerQueue ="FirstConsumer-Events";
    public static final String SecondConsumerQueue = "SecondConsumer-Events";
    public static final String EventExchange = "event-exchange";

    //Listed definitions only possible with boot 1.3.0 +

    @Bean
    List<Queue> consumerQueues(){
        return Arrays.asList(
                new Queue(FirstConsumerQueue, true),
                new Queue(SecondConsumerQueue, true)
        );
    }

    @Bean(name = EventExchange)
    FanoutExchange eventExchange() {
        return new FanoutExchange(EventExchange);
    }

    @Bean
    List<Binding> firstConsumerBinding() {
        List<Binding> result = new ArrayList<>();
        consumerQueues().forEach(it -> result.add(BindingBuilder.bind(it).to(eventExchange())));
        return result;
    }

}
