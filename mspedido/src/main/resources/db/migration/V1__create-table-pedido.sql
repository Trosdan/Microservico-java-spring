CREATE TABLE tb_pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_pedido DATETIME NOT NULL,
    status_pedido VARCHAR(20) NOT NULL
);

CREATE TABLE tb_pedido_produtos (
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES tb_pedidos(id) ON DELETE CASCADE
);