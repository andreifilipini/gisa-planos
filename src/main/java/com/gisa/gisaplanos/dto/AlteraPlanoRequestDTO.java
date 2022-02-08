package com.gisa.gisaplanos.dto;

import com.gisa.gisacore.dto.BasicTransactionRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlteraPlanoRequestDTO extends BasicTransactionRequestDTO {

    private Long idPlano;
}
