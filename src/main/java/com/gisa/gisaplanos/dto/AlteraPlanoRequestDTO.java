package com.gisa.gisaplanos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class AlteraPlanoRequestDTO implements Serializable {

    private Long idAssociado;
    private Long idPlano;
}
