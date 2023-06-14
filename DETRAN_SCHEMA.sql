CREATE DATABASE detran;

use detran;

CREATE TABLE perfil(
	id int auto_increment primary key, 
	nome_perfil varchar(50) NOT NULL
);

CREATE TABLE usuarios(
	id int auto_increment primary key,
    nome_completo varchar(100) NOT NULL,
    dt_nascimento date NOT NULL,
    cpf varchar(20) NOT NULL,
    email varchar(100) NOT NULL,
    telefone varchar(20) NOT NULL,
    senha varchar(50) NOT NULL,
    perfil_id int not null,
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);

insert into perfil(nome_perfil) value ("Aluno");
insert into perfil(nome_perfil) value ("Médico");
insert into perfil(nome_perfil) value ("Agente");
insert into perfil(nome_perfil) value ("Psicólogo");
insert into perfil(nome_perfil) value ("ADMIN");

-- Tabela de questões e provas
 CREATE TABLE questoes(
    id int auto_increment primary key,
    pergunta varchar(900) NOT NULL,
    resposta char NOT NULL
 );
 
 CREATE TABLE provas_teorica(
	id int auto_increment primary key,
    aluno_id int NOT NULL,
    data_prova date NOT NULL, 
    nota int NOT NULL, 
    resultado varchar(20),
    foreign key (aluno_id) references usuarios(id)
 );
 
 -- Inserts na tabela de questões
insert into detran.questoes (pergunta, resposta) values ("Velocidade máxima permitida em uma via arterial? \n\na) 30 km/h \nb) 40 km/h \nc) 50 km/h \nd) 60 km/h", 'd');

insert into detran.questoes (pergunta, resposta) values ("Quando o motorista deve usar o cinto de segurança? \n\na) Somente em viagens longas \nb) Somente em rodovias \nc) Sempre que estiver dirigindo \nd) Somente ao dirigir em alta velocidade", 'c');

insert into detran.questoes (pergunta, resposta) values ("O que significa a luz verde do semáforo? \n\na) Parar \nb) Preparar-se para parar \nc) Ir \nd) Reduzir a velocidade", 'c');

insert into detran.questoes (pergunta, resposta) values ("Se um condutor for pego dirigindo embriagado, qual será a penalidade? \n\na) Multa e suspensão da carteira de motorista \nb) Apreensão do veículo e prisão \nc) Apenas uma advertência escrita \nd) Nenhuma penalidade", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual a função do freio de mão? \n\na) Manter o veículo parado quando estacionado \nb) Controlar a velocidade em descidas \nc) Auxiliar nas manobras de estacionamento \nd) Acionar as luzes de freio", 'a');

insert into detran.questoes (pergunta, resposta) values ("O que significa a sinalização de 'Acesso exclusivo para pedestres' em uma rua? \n\na) Indica a presença de uma faixa de pedestres \nb) Aviso de área de lazer exclusiva para pedestres \nc) Restrição de circulação de veículos na rua \nd)Indica a presença de uma passarela ou escada para pedestres", 'd');

insert into detran.questoes (pergunta, resposta) values ("Quais são as condições ideais para utilizar o farol alto durante a condução noturna? \n\na) Em qualquer condição de visibilidade \nb) Em vias iluminadas \nc) Em vias com tráfego intenso \nd) Em vias não iluminadas e sem a presença de veículos no sentido contrário", 'd');

insert into detran.questoes (pergunta, resposta) values ("O que é uma faixa de pedestres? \n\na) Local de estacionamento exclusivo para pedestres \nb) Área de circulação preferencial para veículos \nc) Espaço destinado à realização de atividades esportivas \nd) Área demarcada na via destinada à travessia segura de pedestres", 'd');

insert into detran.questoes (pergunta, resposta) values ("Qual é a distância mínima que deve ser mantida entre o seu veículo e a bicicleta ao ultrapassá-la? \n\na) 1 metro \nb) 1,5 metros \nc) 2 metros \nd) 3 metros", 'b');

insert into detran.questoes (pergunta, resposta) values ("Qual é a documentação obrigatória que o condutor deve portar ao dirigir um veículo? \n\na) Carteira Nacional de Habilitação (CNH) e documento do veículo \nb) Apenas o documento do veículo \nc) Apenas a Carteira Nacional de Habilitação (CNH) \nd) Nenhuma documentação é obrigatória", 'a');

insert into detran.questoes (pergunta, resposta) values ("O que deve ser feito pelo condutor ao se deparar com um pedestre atravessando a via fora da faixa de pedestres? \n\na) Buzinar para alertar o pedestre \nb) Parar e aguardar o pedestre concluir a travessia \nc) Desviar do pedestre e seguir em frente \nd) Acelerar para atravessar antes do pedestre", 'b');

insert into detran.questoes (pergunta, resposta) values ("Qual é a cor da placa de sinalização que indica 'Pare' em uma via? \n\na) Amarela \nb) Vermelha \nc) Azul \nd) Branca", 'b');

insert into detran.questoes (pergunta, resposta) values ("Qual é a função dos retrovisores em um veículo? \n\na) Aumentar a potência do motor \nb) Melhorar a aerodinâmica do veículo \nc) Auxiliar na visualização de veículos e obstáculos na retaguarda \nd) Sinalizar a intenção de mudar de faixa", 'c');

insert into detran.questoes (pergunta, resposta) values ("O que a sinalização de 'Proibido Ultrapassar' indica? \n\na) Que é permitido realizar ultrapassagens com cuidado \nb) Que é proibido ultrapassar em qualquer situação \nc) Que é permitido ultrapassar somente em trechos retos da via \nd) Que é proibido ultrapassar somente veículos pesados", 'b');

insert into detran.questoes (pergunta, resposta) values ("O que significa a sinalização de 'Passagem de nível sem barreira' em uma via com trilhos de trem? \n\na) Indica uma área de estacionamento para veículos próximos à passagem de nível \nb) Aviso de presença frequente de pedestres na passagem de nível \nc) Indica que a passagem de nível é desprotegida, sem barreiras ou cancelas \nd) Sinaliza a existência de uma área de descarga de materiais na passagem de nível", 'c');

insert into detran.questoes (pergunta, resposta) values ("Qual é a punição para o condutor que excede em mais de 50% a velocidade máxima permitida em uma via? \n\na) Multa e suspensão da carteira de motorista \nb) Apreensão do veículo e prisão \nc) Apenas uma advertência verbal \nd) Nenhuma penalidade", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual é a ação correta do motorista ao se deparar com uma ambulância com sirene ligada? \n\na) Aumentar a velocidade para não atrapalhar o veículo de emergência \nb) Parar imediatamente e liberar passagem \nc) Seguir o veículo de emergência de perto para ter prioridade no trânsito \nd) Continuar normalmente, pois não é obrigado a dar passagem", 'b');

insert into detran.questoes (pergunta, resposta) values ("Qual é a função dos airbags em um veículo? \n\na) Aumentar a velocidade máxima do veículo \nb) Melhorar a economia de combustível \nc) Reduzir o consumo de energia da bateria \nd) Proteger os ocupantes em caso de colisão", 'd');

insert into detran.questoes (pergunta, resposta) values ("Qual é a penalidade prevista para quem estaciona em local destinado a pessoas com deficiência sem a devida autorização? \n\na) Multa e apreensão do veículo \nb) Apenas uma advertência verbal \nc) Suspensão do direito de dirigir por 30 dias \nd) Nenhuma penalidade", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual é a punição prevista para quem estacionar em local proibido para embarque e desembarque de passageiros? \n\na) Multa e perda de pontos na carteira de habilitação \nb) Apreensão do veículo e suspensão da carteira de motorista \nc) Apenas uma advertência escrita \nd) Nenhuma penalidade", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual é o órgão responsável pela fiscalização do trânsito nas rodovias federais no Brasil? \n\na) Polícia Militar \nb) Polícia Rodoviária Federal \nc) Departamento Estadual de Trânsito (Detran) \nd) Agência Nacional de Transportes Terrestres (ANTT)", 'b');

insert into detran.questoes (pergunta, resposta) values ("O que significa a sinalização de 'Pista escorregadia' em uma via? \n\na) Indica que a pista está em boas condições para a condução \nb) Avisa sobre a proximidade de uma área de derramamento de óleo na pista \nc) Indica que a pista está molhada ou com outra substância que reduz a aderência dos pneus \nd) Sinaliza a presença de animais na via", 'c');

insert into detran.questoes (pergunta, resposta) values ("Qual é a documentação obrigatória para conduzir uma motocicleta no Brasil? \n\na) Apenas a Carteira Nacional de Habilitação (CNH) \nb) A Carteira Nacional de Habilitação (CNH) e o Certificado de Registro e Licenciamento do Veículo (CRLV) \nc) Apenas o Certificado de Registro e Licenciamento do Veículo (CRLV) \nd) Nenhuma documentação é obrigatória", 'b');

insert into detran.questoes (pergunta, resposta) values ("Qual é a velocidade máxima permitida em uma via expressa? \n\na) 40 km/h \nb) 60 km/h \nc) 80 km/h \nd) 100 km/h", 'd');

insert into detran.questoes (pergunta, resposta) values ("O que significa a sinalização de 'Carga e descarga permitida' em uma via? \n\na) Proibição de carga e descarga de veículos \nb) Permissão apenas para carga de veículos \nc) Permissão apenas para descarga de veículos \nd) Permissão para carga e descarga de veículos", 'd');

insert into detran.questoes (pergunta, resposta) values ("O que significa a sinalização de 'Proibido estacionar' em uma via? \n\na) É permitido estacionar apenas em horários específicos \nb) É permitido estacionar somente veículos de carga \nc) É proibido estacionar em qualquer momento \nd) É proibido estacionar somente aos finais de semana", 'c');

insert into detran.questoes (pergunta, resposta) values ("Qual é a punição para o condutor que se recusa a fazer o teste do bafômetro? \n\na) Multa e suspensão da carteira de motorista \nb) Apreensão do veículo e prisão \nc) Apenas uma advertência escrita \nd) Nenhuma penalidade", 'a');

insert into detran.questoes (pergunta, resposta) values ("O que significa a placa de trânsito com o desenho de um ponto de ônibus? \n\na) Indica a presença de uma parada de ônibus \nb) Indica uma faixa exclusiva para ônibus \nc) Indica uma área de embarque e desembarque de passageiros \nd)Indica a proximidade de um terminal de ônibus", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual é a penalidade prevista para quem utiliza o celular enquanto dirige? \n\na) Multa e perda de pontos na carteira de habilitação \nb) Apreensão do veículo e suspensão da carteira de motorista \nc) Apenas uma advertência verbal \nd)Nenhuma penalidades", 'a');

insert into detran.questoes (pergunta, resposta) values ("Qual é a distância de frenagem em uma via seca, com um veículo em boas condições e a uma velocidade de 60 km/h? \n\na) Aproximadamente 10 metros \nb) Aproximadamente 20 metros \nc) Aproximadamente 30 metros \nd)Aproximadamente 40 metross", 'c');


-- Tabela de exames
CREATE TABLE tipo_exame(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50)
);

INSERT INTO tipo_exame(nome) values ("Médico");
INSERT INTO tipo_exame(nome) values ("Psicológico");
INSERT INTO tipo_exame(nome) values ("Médico-renovação");
INSERT INTO tipo_exame(nome) values ("Prático");

CREATE TABLE exames(
	id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_exame_id int,
    aluno_id int,
	resultado varchar(30),
    
    foreign key (aluno_id) references usuarios(id),
    foreign key (tipo_exame_id) references tipo_exame(id)
);



CREATE TABLE servicos(
    id int auto_increment primary key,
    nome_item varchar(100) NOT NULL,
    preco_item FLOAT NOT NULL
);

CREATE TABLE carteira(
 id int auto_increment primary key,
 dt_emissao date,
 dt_vencimento date,
 aluno_id int NOT NULL,
 foreign key (aluno_id) REFERENCES usuarios(id)
);

insert into servicos(nome_item, preco_item) values ("Nova CNH", 3500);
insert into servicos(nome_item, preco_item) values ("Segunda via", 460.75);
insert into servicos(nome_item, preco_item) values ("Renovação", 230.45);

CREATE TABLE pagamentos(
	id int auto_increment primary key,
    item_id int, 
    aluno_id int,
    foreign key (item_id) references servicos(id),
    foreign key (aluno_id) references usuarios(id)
);

INSERT INTO usuarios(nome_completo, dt_nascimento, cpf, email, telefone, senha, perfil_id) VALUES ("adm padrao", "2000-12-25", "111.111.111-11", "testeemail@gmail.com", "7592814115", "123", 5);
