CREATE TABLE usuario (
id SERIAL NOT NULL,
nome VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
senha VARCHAR(100) NOT NULL
);

INSERT INTO usuario VALUES (default, 'Usuario', 'usuario@email.com', md5('usuario1'));

CREATE TABLE endereco (
id SERIAL NOT NULL,
descricao VARCHAR(45),
cep VARCHAR(10),
CONSTRAINT pk_endereco PRIMARY KEY(id)
);

CREATE TABLE cliente (
id SERIAL NOT NULL,
nome VARCHAR(150),
email VARCHAR(45),
telefone VARCHAR(45),
cpf VARCHAR(45),
endereco_id INT,
CONSTRAINT pk_cliente PRIMARY KEY(id),
CONSTRAINT fk_cliente_endereco FOREIGN KEY(endereco_id) REFERENCES endereco(id)
);

CREATE TABLE pedido (
id SERIAL NOT NULL,
data_pedido DATE,
endereco_entrega VARCHAR(45),
observacao VARCHAR(500),
cliente_id INT NOT NULL,
CONSTRAINT pk_pedido PRIMARY KEY(id),
CONSTRAINT fk_pedido_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id)
);

CREATE TABLE produto (
id SERIAL NOT NULL,
descricao VARCHAR(150),
valor_unitario DECIMAL(10,2),
qtde_estoque VARCHAR(45),
CONSTRAINT pk_produto PRIMARY KEY(id)
);

CREATE TABLE item_pedido (
id SERIAL NOT NULL,
produto_id INT NOT NULL,
pedido_id INT NOT NULL,
qtde DECIMAL,
valor_item DECIMAL(10,2),
CONSTRAINT pk_item_produto PRIMARY KEY(id),
CONSTRAINT fk_item_produto_produto FOREIGN KEY(produto_id) REFERENCES produto(id),
CONSTRAINT fk_item_produto_pedido FOREIGN KEY(pedido_id) REFERENCES pedido(id)	
);