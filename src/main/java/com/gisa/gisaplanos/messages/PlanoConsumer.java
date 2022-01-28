package com.gisa.gisaplanos.messages;

import com.gisa.gisaplanos.dto.AlteraPlanoRequestDTO;
import com.gisa.gisaplanos.dto.AlteraPlanoResponseDTO;
import com.gisa.gisaplanos.model.service.PlanoService;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PlanoConsumer {

    @Inject
    private RabbitTemplate rabbitTemplate;

    @Inject
    private PlanoService planoService;

    @Value("${queue.changePlanResult}")
    private String changePlanResultQueueName;

    @RabbitListener(queues = {"${queue.changePlan}"})
    private void receive(@Payload String body) {
        Gson gson = new Gson();
        AlteraPlanoRequestDTO request = gson.fromJson(body, AlteraPlanoRequestDTO.class);

        AlteraPlanoResponseDTO response = new AlteraPlanoResponseDTO(request.getIdTransacao(), planoService.isAtivo(request.getIdPlano()));
        rabbitTemplate.convertAndSend(this.changePlanResultQueueName, gson.toJson(response));
    }
}
