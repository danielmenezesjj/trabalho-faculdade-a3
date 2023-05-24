use detran;

CREATE TABLE perfil(
	id int auto_increment primary key, 
	nome_perfil varchar(50) NOT NULL
);
CREATE TABLE usuarios(
	id int auto_increment primary key,
    nome_completo varchar(100) NOT NULL,
    dt_nascimento date NOT NULL,
	adm boolean NOT NULL,
    cpf varchar(20) NOT NULL,
    email varchar(100) NOT NULL,
    telefone varchar(20) NOT NULL,
    senha varchar(50) NOT NULL,
    perfil_id int not null,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);


CREATE TABLE servicos(
	id int auto_increment primary key,
	nome_item varchar(100) not null,
	preco_item FLOAT NOT NULL

);


create table carteira(
id int auto_increment primary key,
dt_emissao date NOT NULL,
dt_vencimento date NOT NULL,
aluno_id int NOT NULL,
foreign key (aluno_id) references usuarios(id)
);

INSERT INTO usuarios(nome_completo, dt_nascimento, adm, cpf, email, telefone, senha, perfil_id) value("daniel menezes", '2000-12-25', true, "123456", "danielmenezes2512@outlook.com", "12356791", "123", 1);
insert into perfil(nome_perfil) value ("ADMIN");
insert servicos(nome_item, preco_item) value("Renovação ", 230.45);



select * from servicos;
select * from usuarios;
select * from perfil;
select * from carteira;





