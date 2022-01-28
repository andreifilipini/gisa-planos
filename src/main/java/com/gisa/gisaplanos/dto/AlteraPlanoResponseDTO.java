package com.gisa.gisaplanos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class AlteraPlanoResponseDTO implements Serializable {

    private Long idTransacao;
    private boolean aprovado;
}
