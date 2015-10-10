package com.example;


import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;


@SpringBootApplication
@EnableScheduling
public class MainProducerApplication implements CommandLineRunner {
    @Autowired
    AnnotationConfigApplicationContext context;



    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
