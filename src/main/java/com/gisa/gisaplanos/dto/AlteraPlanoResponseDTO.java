package com.gisa.gisaplanos.dto;

import com.gisa.gisacore.dto.BasicTransactionResponseDTO;
import com.gisa.gisaplanos.model.TipoAtendimento;
import com.gisa.gisaplanos.model.TipoPlano;
import lombok.Getter;
import lombok.Setter;

@Getter
public class AlteraPlanoResponseDTO extends BasicTransactionResponseDTO {

    private String planoId;

    @Setter
    private TipoAtendimento tipoAtendimento;

    @Setter
    private TipoPlano tipoPlano;

    public AlteraPlanoResponseDTO(Long transactionId, boolean approved, String planoId) {
        super(transactionId, approved);
        this.planoId = planoId;
    }
}
