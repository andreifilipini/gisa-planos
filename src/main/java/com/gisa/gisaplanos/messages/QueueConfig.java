package com.gisa.gisaplanos.messages;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Component
public class QueueConfig {

    @Inject
    private AmqpAdmin amqpAdmin;

    @Value("${queue.changePlanLegacyResult}")
    private String changePlanLegacyResultQueueName;

    @Value("${queue.changePlanResult}")
    private String changePlanResultQueueName;

    @PostConstruct
    protected void createQueues() {
        amqpAdmin.declareQueue(new Queue(this.changePlanLegacyResultQueueName, true));
        amqpAdmin.declareQueue(new Queue(this.changePlanResultQueueName, true));
    }
}
