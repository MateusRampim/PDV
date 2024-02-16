package com.example.demo.webservice;

import com.example.demo.business.models.Vendedor;
import com.example.demo.business.services.VendedorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({ "/api/v1/vendedores","/api/v1/vendedores/{id}"})
public class VendedorController {
    @Autowired
    VendedorService vendedorService;
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    public Vendedor cadastrarVendedor(@RequestBody Vendedor vend) {
        return vendedorService.criar(vend);
    }

    @DeleteMapping
    public void excluirVendedor(@PathVariable UUID id) {
        vendedorService.excluir(id);
    }

    @GetMapping
    public List<Vendedor> buscarVendedor(@ModelAttribute Vendedor vendedor) {
        return vendedorService.buscar(vendedor);
    }

    @PutMapping
    public Vendedor editar(@RequestBody Vendedor vendedor) {
        return vendedorService.editar(vendedor);
    }


}
