package com.example;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Eric on 10/10/2015.
 */
@Service
public class SpamService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 500)
    public void reportCurrentTime() {
        rabbitTemplate.convertAndSend(GlobalRabbitConfiguration.EventExchange, "event", "Hello from RabbitMQ!" + new Date().toString());
    }
}
