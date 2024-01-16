package com.example.demo;

import com.example.demo.models.Vendedor;
import com.example.demo.services.VendedorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api/v1/vendedores")
public class VendedorController {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    VendedorService vendedorService;

    @PostMapping
    public Vendedor cadastrarVendedor(@RequestBody Vendedor vend) {
         return vendedorService.criar(vend);
    }

    @DeleteMapping
    public void excluirVendedor(@RequestBody Vendedor vendedor){
        vendedorService.excluir(vendedor);
    }

    @GetMapping
    public List<Vendedor> buscarVendedor(@RequestBody(required = false)Vendedor vendedor) {
        return  vendedorService.buscar(vendedor);
    }
    @PutMapping
    public Vendedor editar(@RequestBody Vendedor vendedor){
        return vendedorService.editar(vendedor);
    }



}
