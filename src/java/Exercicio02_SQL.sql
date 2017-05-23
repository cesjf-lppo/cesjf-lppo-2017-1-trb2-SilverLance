DROP TABLE Coleta;

CREATE TABLE Coleta(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(100) NOT NULL,
    data TIMESTAMP NOT NULL
);

DROP TABLE Leitura; 

CREATE TABLE Leitura(
    id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    coleta INTEGER NOT NULL,
    local VARCHAR(50) NOT NULL,
    leitura REAL NOT NULL,
    unidade VARCHAR(20) NOT NULL,
    atualizacao TIMESTAMP,
    CONSTRAINT Leitura_Coleta FOREIGN KEY (coleta)
        REFERENCES Coleta (id)
);
