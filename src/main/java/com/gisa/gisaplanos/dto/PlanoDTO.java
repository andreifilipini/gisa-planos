package com.gisa.gisaplanos.dto;

import com.gisa.gisaplanos.model.TipoAtendimento;
import com.gisa.gisaplanos.model.TipoPlano;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PlanoDTO {

	private Long id;

	private String descricao;

	private Long qtdConsultasAno;

	private Long qtdExamesAno;

	private BigDecimal valor;

	private TipoAtendimento tipoAtendimento;

	private TipoPlano tipoPlano;
}
