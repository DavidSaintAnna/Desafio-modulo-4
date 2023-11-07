CREATE DATABASE db;


USE db;

CREATE TABLE Aeroportos (
    id_aeroporto INT PRIMARY KEY auto_increment,
    nome VARCHAR(255),
    cidade VARCHAR(255),
    pais VARCHAR(255)
);


CREATE TABLE Passagens (
    id_passagem INT PRIMARY KEY auto_increment,
    id_aeroporto INT,
    nome VARCHAR(255),
    preco SMALLINT,
    data_de_saida DATE,
    data_de_chegada DATE,
    data_de_retorno DATE,
    FOREIGN KEY (id_aeroporto) REFERENCES Aeroportos (id_aeroporto)
);

CREATE TABLE Usuarios (
    id_usuario INT PRIMARY KEY auto_increment,
    id_passagem INT,
    email VARCHAR(255),
    nome VARCHAR(255),
    senha VARCHAR(255),
    FOREIGN KEY (id_passagem) REFERENCES Passagens (id_passagem)
);


CREATE TABLE Comentarios (
    id_comentario INT PRIMARY KEY auto_increment,
    id_usuario INT,
    comentario VARCHAR(255),
    data_de_publicacao DATE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario)
);