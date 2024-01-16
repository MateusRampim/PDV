package com.example.demo.models;

import java.util.List;

public class VendaRequest {
    private Venda venda;
    private List<Item> items;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VendaRequest{" +venda.toString()+items.toString()+
                '}';
    }

    public VendaRequest() {
    }
}
