package com.example.demo.services;

import com.example.demo.models.Item;
import com.example.demo.models.ItensVendidos;
import com.example.demo.models.Venda;
import com.example.demo.models.VendaRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendaService {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public Venda criar(VendaRequest vendaRequest) {
        String query = "INSERT INTO venda (id, vendedor_id, dia, total) VALUES (uuid_generate_v4(), :vendedor, CURRENT_DATE, :total) RETURNING *";

        Venda venda = (Venda) entityManager.createNativeQuery(query, Venda.class)
                .setParameter("vendedor", vendaRequest.getVenda().getVendedor().getId())
                .setParameter("total", vendaRequest.getVenda().getTotal())
                .getSingleResult();
        for (Item item : vendaRequest.getItems()) {
            String itemQuery = "INSERT INTO venda_item (id,venda_id, item_vendido_id) VALUES (uuid_generate_v4(),:venda, :item_id)";
            entityManager.createNativeQuery(itemQuery, ItensVendidos.class)
                    .setParameter("venda", venda.getId())
                    .setParameter("item_id", item.getId())
                    .executeUpdate();
        }

        return venda;
    }
    @Transactional
    public void excluir(Venda venda){
        if (venda.getId() != null){
            String query = "DELETE FROM venda_item WHERE venda_id = :id;" +
                    "DELETE FROM venda WHERE id = :id;";
            entityManager.createNativeQuery(query).setParameter("id",venda.getId()).executeUpdate();
        }

    }

}
