package com.example.demo.models;

import java.io.Serializable;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "venda")
public class Venda  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "total")
    private float total;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column(name = "dia")
    private Date dia;
    // Constructors, getters, setters, etc.

    public Venda() {
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", total=" + total +
                ", vendedor=" + vendedor.toString() +
                ", dia=" + dia +
                '}';
    }

    public Venda(float total, Vendedor vendedor, Date dia) {
        this.total = total;
        this.vendedor = vendedor;
        this.dia = dia;
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }
}
