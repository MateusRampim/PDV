CREATE TABLE Vendedor (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    contato VARCHAR(255)
);

CREATE TABLE Itens (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    estoque INT,
    valor DECIMAL(10, 2)
);

CREATE TABLE Venda (
    id UUID PRIMARY KEY,
    total FLOAT,
    vendedor_id UUID,
    dia DATE,
    FOREIGN KEY (vendedor_id) REFERENCES Vendedor(id)
);


CREATE TABLE Venda_ItemVendido (
    venda_id UUID,
    item_vendido_id UUID,
    PRIMARY KEY (venda_id, item_vendido_id),
    FOREIGN KEY (venda_id) REFERENCES Venda(id),
    FOREIGN KEY (item_vendido_id) REFERENCES Itens(id)
);
