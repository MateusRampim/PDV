package com.example.demo.models;

import java.io.Serializable;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Venda")
public class Venda  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Vendedor vendedor;
    private float total; 

    public float getTotal() {
        return total;
    }


    public void setTotal(float total) {
        this.total = total;
    }


    public UUID getId() {
        return this.id;
    }


    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


}
