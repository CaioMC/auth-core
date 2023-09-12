CREATE TABLE IF NOT EXISTS clinica
(
    id             UUID        NOT NULL,
    nome           VARCHAR     NOT NULL,
    email          VARCHAR,
    numero_cnes    VARCHAR,
    cep            VARCHAR,
    endereco       VARCHAR,
    numero         int,
    complemento    VARCHAR,
    bairro         VARCHAR,
    cidade         VARCHAR,
    uf             SMALLINT,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_clinica PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS funcao_profissional
(
    id              UUID        NOT NULL,
    profissional_id UUID        NOT NULL,
    funcao          SMALLINT    NOT NULL,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_funcao_profissional PRIMARY KEY (id)
);

CREATE INDEX idx_funcao_profissional_profissional_id ON funcao_profissional (profissional_id);

CREATE TABLE IF NOT EXISTS profissional
(
    id                      UUID        NOT NULL,
    tipo                    SMALLINT    NOT NULL,
    email                   VARCHAR,
    nome                    VARCHAR     NOT NULL,
    cpf                     VARCHAR     NOT NULL,
    celular                 VARCHAR     NOT NUll,
    sexo                    SMALLINT    NOT NULL,
    tratamento              SMALLINT,
    concelho_profissional   SMALLINT,
    registro                VARCHAR,
    uf                      SMALLINT   NOT NUll,
    profissao               SMALLINT,
    cbo                     VARCHAR,
    rqe                     VARCHAR,
    cnes                    VARCHAR,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_profissional PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS profissional_clinica
(
    id               UUID        NOT NULL,
    clinica_id       UUID        NOT NULL,
    profissional_id  UUID        NOT NULL,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_profissional_clinica PRIMARY KEY (id)
);

CREATE INDEX idx_profissional_clinica_clinica_id ON profissional_clinica (clinica_id);
CREATE INDEX idx_profissional_clinica_prifissional_id  ON profissional_clinica (profissional_id);

CREATE TABLE IF NOT EXISTS telefone_clinica
(
    id               UUID        NOT NULL,
    clinica_id       UUID        NOT NULL,
    telefone         VARCHAR     NOT NULL,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_telefone_clinica PRIMARY KEY (id)
);

CREATE INDEX idx_telefone_clinica_clinica_id ON telefone_clinica (clinica_id);

CREATE TABLE IF NOT EXISTS auth
(
    id                    UUID        NOT NULL,
    profissional_id       UUID        NOT NULL,
    refresh_token         VARCHAR,
    password              VARCHAR     NOT NULL,
    clinica_id            UUID        NOT NULL,

    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_auth PRIMARY KEY (id)
);

CREATE INDEX idx_auth_profissional_id ON auth (profissional_id);
CREATE INDEX idx_auth_clinica_id ON auth (clinica_id);




