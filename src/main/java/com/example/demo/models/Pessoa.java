package com.example.demo.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pessoas")
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idpessoa;
    private String nome;
    private BigDecimal idade;

    public UUID getIdpessoa() {
        return this.idpessoa;
    }

    public void setIdpessoa(UUID idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getIdade() {
        return this.idade;
    }

    public void setIdade(BigDecimal idade) {
        this.idade = idade;
    }

}
