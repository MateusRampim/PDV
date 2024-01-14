package com.example.demo;

import com.example.demo.models.Vendedor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vendedores" )
public class VendedorController {

    @PostMapping
    public Vendedor cadastrarVendedor() {
        return null;
    }

    @GetMapping
    public List<Vendedor> buscarVendedor() {
        return Collections.emptyList();
    }

}
