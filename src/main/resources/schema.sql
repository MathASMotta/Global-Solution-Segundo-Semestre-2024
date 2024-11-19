CREATE TABLE cliente (
    cliente_uuid VARCHAR2(36) PRIMARY KEY,
    nome VARCHAR2(255) NOT NULL,
    endereco VARCHAR2(255) NOT NULL,
    documento VARCHAR2(20) UNIQUE NOT NULL,
    tipo_cliente VARCHAR2(2) NOT NULL,
    cep VARCHAR2(10) NOT NULL,
    ativo NUMBER(1) DEFAULT 1
);

CREATE TABLE instalacao (
    instalacao_uuid VARCHAR2(36) PRIMARY KEY,
    endereco VARCHAR2(255) NOT NULL,
    cep VARCHAR2(10) NOT NULL,
    ativo NUMBER(1) DEFAULT 1
);

CREATE TABLE contrato (
    contrato_uuid VARCHAR2(36) PRIMARY KEY,
    cliente_uuid VARCHAR2(36) REFERENCES cliente(cliente_uuid),
    instalacao_uuid VARCHAR2(36) REFERENCES instalacao(instalacao_uuid),
    data_inicio DATE NOT NULL,
    duracao_dias NUMBER NOT NULL CHECK (duracao_dias IN (90, 180, 270, 360, 450, 540, 630, 720, 810)),
    ativo NUMBER(1) DEFAULT 1
);
