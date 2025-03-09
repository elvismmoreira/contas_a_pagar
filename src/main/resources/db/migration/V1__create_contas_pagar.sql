CREATE TABLE contas_pagar (
     id UUID NOT NULL,
     descricao VARCHAR(255),
     valor NUMERIC(15, 2),
     data_vencimento TIMESTAMP,
     data_pagamento  TIMESTAMP,
     situacao VARCHAR(50)
);