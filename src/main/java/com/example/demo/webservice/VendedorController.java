package com.example.demo.webservice;

import com.example.demo.business.models.Vendedor;
import com.example.demo.business.services.VendedorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
