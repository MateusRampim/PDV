package com.example.demo;

import com.example.demo.models.Item;
import com.example.demo.models.Venda;
import com.example.demo.models.VendaRequest;
import com.example.demo.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendasController {
    @Autowired
    VendaService vendaService;
    @PostMapping
    public Venda criar(@RequestBody VendaRequest vendaRequest){
        System.out.println(vendaRequest.toString());
        return vendaService.criar(vendaRequest);
    }
    @DeleteMapping
    public void excluir(@RequestBody Venda venda){
        vendaService.excluir(venda);
    }
}
