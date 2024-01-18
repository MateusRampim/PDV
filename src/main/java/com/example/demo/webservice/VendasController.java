package com.example.demo.webservice;

import com.example.demo.api.VendaBuscar;
import com.example.demo.api.VendaRequest;
import com.example.demo.business.models.Venda;
import com.example.demo.business.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vendas")
public class VendasController {
    @Autowired
    VendaService vendaService;

    @PostMapping
    public Venda criar(@RequestBody VendaRequest vendaRequest) {
        System.out.println(vendaRequest.toString());
        return vendaService.criar(vendaRequest);
    }

    @DeleteMapping
    public void excluir(@RequestBody Venda venda) {
        vendaService.excluir(venda);
    }

    @GetMapping
    public List<VendaRequest> buscar(@ModelAttribute VendaBuscar venda) {
        return vendaService.buscar(venda);
    }
}
