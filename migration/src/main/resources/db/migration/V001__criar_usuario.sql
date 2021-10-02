CREATE TABLE usuarios (
	id int8 NOT NULL,
	nome varchar(250) NOT NULL,
	idade integer NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

INSERT INTO usuarios(id, nome, idade) VALUES (1,  'Jean Alexandre Dobre', 38);
INSERT INTO usuarios(id, nome, idade) VALUES (2,  'Fulano de tal', 28);