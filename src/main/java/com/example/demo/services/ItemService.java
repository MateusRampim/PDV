package com.example.demo.services;

import com.example.demo.models.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/*
*
*
* */
@Service
public class ItemService {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Item criar(Item item){
        String query = "INSERT INTO itens (id, nome, estoque,valor) VALUES (uuid_generate_v4(),  :nome , :estoque,:valor ) RETURNING *";

        return (Item) entityManager.createNativeQuery(query, Item.class)
                .setParameter("nome",item.getNome())
                .setParameter("estoque",item.getEstoque()).setParameter("valor",item.getValor())
                .getSingleResult();
    }
    @Transactional
    public List<Item> buscar(Item item){
        if (item != null){
            if (item.getId() != null){
                String query = "SELECT * FROM itens WHERE id = :id";
                return entityManager.createNativeQuery(query,Item.class).setParameter("id",item.getId()).getResultList();
            } else if (item.getNome()!= null) {
                String query = "SELECT * FROM itens WHERE nome = :nome";
                return entityManager.createNativeQuery(query,Item.class).setParameter("nome",item.getNome()).getResultList();

            }
        }
        String query = "SELECT * FROM itens";
        return entityManager.createNativeQuery(query, Item.class).getResultList();


    }
    @Transactional
    public void excluir(Item item){
        if (item.getId() != null){
            String query = "DELETE FROM itens WHERE id = :id";
            entityManager.createNativeQuery(query).setParameter("id",item.getId()).executeUpdate();
        } else if (item.getNome()!= null) {
            String query = "DELETE FROM itens WHERE nome = :nome";
            entityManager.createNativeQuery(query).setParameter("nome",item.getNome()).executeUpdate();
        }

    }

    @Transactional
    public Item editar(Item item){
        if (item.getId() != null){
            if (item.getNome()!= null){
                String query ="UPDATE Itens SET nome = :nome WHERE id = :id RETURNING *";
                return (Item) entityManager.createNativeQuery(query, Item.class).setParameter("id",item.getId()).setParameter("nome",item.getNome()).getSingleResult();
            } else if (item.getEstoque()!= 0) {
                String query ="UPDATE Itens SET estoque = :estoque WHERE id = :id RETURNING *";
                return (Item) entityManager.createNativeQuery(query, Item.class).setParameter("id",item.getId()).setParameter("estoque",item.getEstoque()).getSingleResult();
            }
        }

        return null;
    }
}
