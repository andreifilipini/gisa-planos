package com.gisa.gisaplanos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gisa.gisaplanos.dto.PlanoDTO;
import com.gisa.gisaplanos.model.Plano;
import com.gisa.gisaplanos.model.service.PlanoService;

@RestController
@RequestMapping("/plano")
public class PlanoController {

	@Autowired
	private PlanoService planoService;

	@GetMapping
	public ResponseEntity<List<PlanoDTO>> findAll() {
		List<Plano> planos = planoService.findAll();
		return ResponseEntity.ok(planos.stream().map(this::toDTO).collect(Collectors.toList()));
	}

	private PlanoDTO toDTO(Plano plano) {
		return PlanoDTO.builder().id(plano.getId()).descricao(plano.getDescricao()).ativo(plano.isAtivo())
				.qtdConsultasAno(plano.getQtdConsultasAno()).qtdExamesAno(plano.getQtdExamesAno())
				.valor(plano.getValor()).tipoAtendimento(plano.getTipoAtendimento()).build();
	}

}
