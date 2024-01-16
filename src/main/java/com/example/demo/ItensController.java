package com.example.demo;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itens")
public class ItensController {

    @Autowired
    ItemService itemService;
    @PersistenceContext
    private EntityManager entityManager;

    public ItensController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item cadastrarItens(@RequestBody Item item) {

        return itemService.criar(item);
    }

    @DeleteMapping()
    @Transactional
    public void excluirItem(@RequestBody Item item){
        itemService.excluir(item);
    }

    @GetMapping
    public List<Item> buscarItens(@RequestBody(required = false)Item item) {
        return itemService.buscar(item);
    }



    @PutMapping
    @Transactional
    public Item editar(@RequestBody Item item) {

        return itemService.editar(item);
    }


}
