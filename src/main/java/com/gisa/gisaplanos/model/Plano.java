package com.gisa.gisaplanos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
public class Plano {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Setter
	private String descricao;

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
