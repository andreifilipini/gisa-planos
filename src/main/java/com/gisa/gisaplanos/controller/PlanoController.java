package com.gisa.gisaplanos.controller;

import com.gisa.gisacore.exception.InfraException;
import com.gisa.gisaplanos.dto.PlanoDTO;
import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plano")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> findAll() {
        try {
            return ResponseEntity.ok(
                    planoService.findAll().stream()
                            .map(this::toDTO)
                            .collect(Collectors.toList()));
        } catch (InfraException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private PlanoDTO toDTO(Plano plano) {
        return PlanoDTO.builder().id(plano.getId()).descricao(plano.getDescricao())
                .qtdConsultasAno(plano.getQtdConsultasAno()).qtdExamesAno(plano.getQtdExamesAno())
                .valor(plano.getValor()).tipoAtendimento(plano.getTipoAtendimento()).tipoPlano(plano.getTipoPlano())
                .build();
    }

}
