package com.gisa.gisaplanos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Plano {

	@Id
	private Long id;

	@NotNull
	@Setter
	private String descricao;

	@Setter
	private boolean ativo;

	@Setter
	private Long qtdConsultasAno;

	@Setter
	private Long qtdExamesAno;

	@Setter
	private BigDecimal valor;

	@Setter
	@Enumerated(EnumType.STRING)
	private TipoAtendimento tipoAtendimento;

	@Setter
	@Enumerated(EnumType.STRING)
	private TipoPlano tipoPlano;
}
