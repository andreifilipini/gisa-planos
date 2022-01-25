package com.gisa.gisaplanos.messages;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class PlanoConsumer {

    @Inject
    private AmqpAdmin amqpAdmin;

    @Inject
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.changePlan}")
    private String changePlanQueueName;

    @Value("${queue.changePlanResult}")
    private String changePlanResultQueueName;

    @PostConstruct
    protected void createQueues() {
        amqpAdmin.declareQueue(new Queue(this.changePlanQueueName, true));
        amqpAdmin.declareQueue(new Queue(this.changePlanResultQueueName, true));
    }

    @RabbitListener(queues = {"${queue.changePlan}"})
    private void receive(@Payload String body) {
        System.out.println(String.format("hakuna matata: %s", body));
        rabbitTemplate.convertAndSend(this.changePlanResultQueueName, "resultado!");
    }
}
