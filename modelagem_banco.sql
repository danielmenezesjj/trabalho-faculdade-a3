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
insert into perfil(nome_perfil) value ("ADMIN");
INSERT INTO usuarios(nome_completo, dt_nascimento, adm, cpf, email, telefone, senha, perfil_id) value("daniel menezes", '2000-12-25', true, "1234567891", "danielmenezes2512@outlook.com", "12356791", "123", 5);






