CREATE DATABASE gerenciador_projetos;
USE gerenciador_projetos;
CREATE TABLE tarefas(
    id bigint primary key NOT NULL AUTO_INCREMENT,
    responsavel varchar(120),
    status varchar(50),
    descricao varchar(1000)
) ENGINE = InnoDB;
DESCRIBE tarefas;