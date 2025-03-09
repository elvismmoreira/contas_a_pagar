package com.pagamentos.contas_a_pagar.application.mapper;

import com.pagamentos.contas_a_pagar.application.dtos.ContasPagarDTO;
import com.pagamentos.contas_a_pagar.domain.model.ContasPagar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = ContasPagarDTO.class)
public interface ContasPagarMapper {

    //ContasPagarMapper INSTANCE = Mappers.getMapper(ContasPagarMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "data_vencimento", target = "data_vencimento")
    @Mapping(source = "data_pagamento", target = "data_pagamento")
    @Mapping(source = "situacao", target = "situacao")
    ContasPagar toEntity(ContasPagarDTO dto);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "data_vencimento", target = "data_vencimento")
    @Mapping(source = "data_pagamento", target = "data_pagamento")
    @Mapping(source = "situacao", target = "situacao")
    ContasPagarDTO toDTO(ContasPagar entity);
}
