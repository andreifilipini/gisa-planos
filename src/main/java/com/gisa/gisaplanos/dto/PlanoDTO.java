package com.gisa.gisaplanos.dto;

import java.math.BigDecimal;

import com.gisa.gisaplanos.model.TipoAtendimento;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PlanoDTO {

	private Long id;

	private String descricao;

	private boolean ativo;

	private Long qtdConsultasAno;

	private Long qtdExamesAno;
	
	private BigDecimal valor;

	private TipoAtendimento tipoAtendimento;
}
