package com.example.demo.webservice;

import com.example.demo.business.models.Item;
import com.example.demo.business.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itens")
public class ItensController {

    @Autowired
    ItemService itemService;

    @PostMapping
    public Item cadastrarItens(@RequestBody Item item) {
        return itemService.criar(item);
    }
    /* PathParam*/
    @DeleteMapping()
    public void excluirItem(@RequestBody Item item) {
        itemService.excluir(item);
    }
/* RequestParam*/
    @GetMapping
    public List<Item> buscarItens(@RequestBody(required = false) Item item) {
        return itemService.buscar(item);
    }

    @PutMapping
    public Item editar(@RequestBody Item item) {
        return itemService.editar(item);
    }

}
