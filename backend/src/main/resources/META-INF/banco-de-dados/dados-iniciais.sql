--TB_USUARIOS
INSERT INTO TB_USUARIOS (ID,NOME,USERNAME,PASSWORD) VALUES (SEQ_USUARIO.NEXTVAL,'Luciene Alves','luciene','123456');
INSERT INTO TB_USUARIOS (ID,NOME,USERNAME,PASSWORD) VALUES (SEQ_USUARIO.NEXTVAL,'Assis Lima','assis','123456');
INSERT INTO TB_USUARIOS (ID,NOME,USERNAME,PASSWORD) VALUES (SEQ_USUARIO.NEXTVAL,'Carlos Roberto','roberto','123456');
INSERT INTO TB_USUARIOS (ID,NOME,USERNAME,PASSWORD) VALUES (SEQ_USUARIO.NEXTVAL,'Super Boss','boss','123456');

--TB_ROLES
INSERT INTO TB_ROLES (ID,NOME) VALUES (SEQ_ROLE.NEXTVAL,'Admin');
INSERT INTO TB_ROLES (ID,NOME) VALUES (SEQ_ROLE.NEXTVAL,'Supervisor');
INSERT INTO TB_ROLES (ID,NOME) VALUES (SEQ_ROLE.NEXTVAL,'Auxiliar');

--TB_ROLES POR TB_USUARIOS
INSERT INTO TB_ROLES_TB_USUARIOS(ROLES_ID,USUARIOS_ID) VALUES (1,1);
INSERT INTO TB_ROLES_TB_USUARIOS(ROLES_ID,USUARIOS_ID) VALUES (2,2);
INSERT INTO TB_ROLES_TB_USUARIOS(ROLES_ID,USUARIOS_ID) VALUES (3,3);
INSERT INTO TB_ROLES_TB_USUARIOS(ROLES_ID,USUARIOS_ID) VALUES (3,4);

--TB_MARCAS
INSERT INTO TB_MARCAS (ID, NOME,DESCRICAO) VALUES (SEQ_MARCA.NEXTVAL, 'Apple', 'Empresa Apple');
INSERT INTO TB_MARCAS (ID, NOME,DESCRICAO) VALUES (SEQ_MARCA.NEXTVAL, 'Google', 'Empresa Google');
INSERT INTO TB_MARCAS (ID, NOME,DESCRICAO) VALUES (SEQ_MARCA.NEXTVAL, 'Microsoft', 'Empresa Microsoft');

--TB_PRODUTOS
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'IPhone 9','Aparelho Celular',1);
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'IPhone 10','Aparelho Celular',1);
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'Microsoft 365','Word, Excel, Power Point, Access',3);
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'One Drive','Repositório na Nuvem',3);
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'Google Drive','Repositório na Nuvem',2);
INSERT INTO TB_PRODUTOS (ID, NOME, DESCRICAO, ID_MARCA_FK) VALUES (SEQ_PRODUTO.NEXTVAL, 'Google HangOut','Dispositivo de Conversa Online',2);


