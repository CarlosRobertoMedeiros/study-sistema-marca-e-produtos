--Criação da Sequence
CREATE SEQUENCE APP.eventos_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;


--Criação da Tabela(DDL)
CREATE TABLE APP.TB_Eventos
( id_evento NUMBER NOT NULL,
  nome varchar2(50) NOT NULL,
  data_criacao date not null,
  CONSTRAINT id_pk PRIMARY KEY (id_evento)
);

--Criação da Trigger para Trabalhar com o Campo AutoIncremento
-- Versão Oracle 11g
CREATE OR REPLACE TRIGGER APP.tr_insere_seq_eventos 
BEFORE INSERT ON APP.TB_Eventos 
FOR EACH ROW

BEGIN
  SELECT APP.eventos_seq.NEXTVAL
  INTO   :new.id_evento
  FROM   dual;
END;
/

--Inserção dos Dados(DML)
INSERT INTO APP.Tb_Eventos(nome,data_criacao) values('Lavar a Louça', sysdate);
INSERT INTO APP.Tb_Eventos(nome,data_criacao) values('Arrumar a Casa', sysdate);
INSERT INTO APP.Tb_Eventos(nome,data_criacao) values('Dar banho nos meninos', sysdate);
INSERT INTO APP.Tb_Eventos(nome,data_criacao) values('Escovar os dentes', sysdate);