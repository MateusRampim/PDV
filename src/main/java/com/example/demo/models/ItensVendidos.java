package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venda_ItemVendido")
public class ItensVendidos {
    @ManyToOne
    private Itens item;
    @Id
    private int id;
    /**
     *
     */
    @ManyToOne
    private Vendedor vendedor;

    public Itens getItem() {
        return this.item;
    }

    public void setItem(Itens item) {
        this.item = item;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

}
