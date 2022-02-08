package com.gisa.gisaplanos.messages;

import com.gisa.gisacore.messages.AbstractRabbitConsumer;
import com.gisa.gisaplanos.dto.AlteraPlanoResponseDTO;
import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.service.PlanoService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Slf4j
@Component
public class AlteraPlanoLegacyConsumer extends AbstractRabbitConsumer {

    @Inject
    private RabbitTemplate rabbitTemplate;

    @Inject
    private PlanoService planoService;

    @Value("${queue.changePlanResult}")
    private String changePlanResultQueueName;

    @RabbitListener(queues = {"${queue.changePlanLegacyResult}"})
    protected void receive(@Payload String body) {
        executeLoggin(body);
    }

    @Override
    protected void execute(@Payload String body) {
        Gson gson = new Gson();
        AlteraPlanoResponseDTO legacyResponse = gson.fromJson(body, AlteraPlanoResponseDTO.class);

        Plano plano = planoService.findById(legacyResponse.getIdPlano());
        AlteraPlanoResponseDTO response = new AlteraPlanoResponseDTO(legacyResponse.getTransactionId(), legacyResponse.isApproved(), legacyResponse.getIdPlano());
        if (plano != null) {
            response.setTipoAtendimento(plano.getTipoAtendimento());
            response.setTipoPlano(plano.getTipoPlano());
        }
        rabbitTemplate.convertAndSend(this.changePlanResultQueueName, gson.toJson(response));
    }

    @Override
    protected Logger getLogger() {
        return log;
    }
}
