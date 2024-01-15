package com.example.demo.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Itens")
public class Itens  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private int estoque;

    public Itens(String nome, int estoque, float valor) {
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
    }

    public Itens() {
    }

    private float valor;

    public UUID getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
